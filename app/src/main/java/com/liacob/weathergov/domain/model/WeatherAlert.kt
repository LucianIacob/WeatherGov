package com.liacob.weathergov.domain.model

data class WeatherAlert(
    val event: String,
    val senderName: String,
    val effective: String,
    val ends: String?,
)
