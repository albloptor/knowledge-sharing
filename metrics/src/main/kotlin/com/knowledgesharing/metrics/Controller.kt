package com.knowledgesharing.metrics

import io.micrometer.core.annotation.Timed
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.Duration
import java.util.concurrent.atomic.AtomicInteger


@RestController
class Controller(
    private val meterRegistry: MeterRegistry
) {

    private val temperature: AtomicInteger = AtomicInteger(20)
    private val contentfulClientTimer = Timer.builder("http.client.requests")
        .tags("content", "adverts", "content_source", "contentful")
        .publishPercentileHistogram()
        .serviceLevelObjectives(Duration.ofMillis(100))
        .minimumExpectedValue(Duration.ofMillis(30))
        .maximumExpectedValue(Duration.ofMillis(500))
        .register(meterRegistry)
    private val citrusAdClientTimer = Timer.builder("http.client.requests")
        .tags("content", "adverts", "content_source", "citrus-ad")
        .publishPercentileHistogram()
        .serviceLevelObjectives(Duration.ofMillis(300))
        .minimumExpectedValue(Duration.ofMillis(80))
        .maximumExpectedValue(Duration.ofMillis(450))
        .register(meterRegistry)

    init {
        meterRegistry.gauge("temperature", temperature)
    }

    @GetMapping("/")
    fun greet(): String {
        return "Greetings from Spring Boot!"
    }

    @GetMapping("/greet")
    fun greetUser(@RequestParam("name") name: String): String {
        val counter = meterRegistry.counter("greetings", "name", name)
        counter.increment()
        return "Hello, $name! Greeted ${counter.count()} times."
    }

    @PutMapping("/temperature")
    fun setTemperature(@RequestBody requestBody: TemperatureRequestBody): String {
        temperature.set(requestBody.degreesCelsius)
        return "Temperature has been set to $temperature degrees Celsius."
    }

    @PostMapping("/error")
    fun error(): ResponseEntity<Unit> {
        waitBetween(minDuration = Duration.ofSeconds(0), maxDuration = Duration.ofMillis(1500))
        return ResponseEntity.internalServerError().build()
    }

    @PostMapping("/error2")
    fun error2(): ResponseEntity<Unit> {
        waitBetween(minDuration = Duration.ofSeconds(0), maxDuration = Duration.ofSeconds(2))
        return if (System.currentTimeMillis() % 3 == 0L) {
            ResponseEntity.ok()
        } else {
            ResponseEntity.internalServerError()
        }.build()
    }

    @GetMapping("/adverts")
    @Timed("adverts.timer", histogram = true)
    fun getAdverts(): String {
        getAdvertsFromContentful()
        getAdvertsFromCitrusAd()
        return "Some adverts."
    }

    private fun getAdvertsFromContentful() {
        contentfulClientTimer.record(Runnable {
            waitBetween(
                minDuration = Duration.ofMillis(50),
                maxDuration = Duration.ofMillis(150)
            )
        })
    }

    private fun getAdvertsFromCitrusAd() {
        citrusAdClientTimer.record(Runnable {
            waitBetween(
                minDuration = Duration.ofMillis(100),
                maxDuration = Duration.ofMillis(500)
            )
        })
    }

    private fun waitBetween(minDuration: Duration, maxDuration: Duration) {
        val waitingTime = (Math.random() * (maxDuration.toMillis() - minDuration.toMillis())) + minDuration.toMillis()
        return Thread.sleep(waitingTime.toLong())
    }

}