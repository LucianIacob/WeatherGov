package com.liacob.weathergov.domain.model

import java.time.Duration
import java.time.ZonedDateTime

data class WeatherAlert(
    val event: String,
    val senderName: String,
    val effective: ZonedDateTime,
    val ends: ZonedDateTime?,
    val duration: Duration?,
)
