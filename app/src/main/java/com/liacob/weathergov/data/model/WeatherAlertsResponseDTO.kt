package com.liacob.weathergov.data.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class WeatherAlertsResponseDTO(
    @SerialName("features") val alerts: List<WeatherAlertDTO>,
)
