package com.liacob.weathergov.data.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class WeatherAlertDTO(
    @SerialName("properties") val properties: AlertPropertiesDTO,
)
