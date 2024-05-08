plugins {
    id("java")
    id("groovy")
}

group = "com.albertolopez.knowledge-sharing"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.spockframework:spock-core:2.4-M4-groovy-4.0")
}

tasks.test {
    useJUnitPlatform()
}
