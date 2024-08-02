package com.knowledgesharing.metrics

import com.fasterxml.jackson.annotation.JsonProperty

class TemperatureRequestBody(
    @JsonProperty("degreesCelsius") val degreesCelsius: Int
)