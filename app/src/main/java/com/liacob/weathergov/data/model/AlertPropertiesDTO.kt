package com.liacob.weathergov.data.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
class AlertPropertiesDTO(
    @SerialName("event") val event: String,
    @SerialName("senderName") val senderName: String,
    @SerialName("effective") val effective: String, // start date
    @SerialName("ends") val ends: String?, // end date
)
