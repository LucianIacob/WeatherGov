package com.liacob.weathergov.data.mapper

import com.liacob.weathergov.data.model.WeatherAlertsResponseDTO
import com.liacob.weathergov.domain.model.WeatherAlert

class AlertsMapper {
    fun mapToDomainEntity(response: WeatherAlertsResponseDTO): List<WeatherAlert> =
        response.alerts.map {
            WeatherAlert(
                it.properties.event,
                it.properties.senderName,
                it.properties.effective,
                it.properties.ends,
            )
        }
}
