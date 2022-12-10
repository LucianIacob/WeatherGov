package com.liacob.weathergov.data.mapper

import com.liacob.weathergov.data.model.WeatherAlertsResponseDTO
import com.liacob.weathergov.domain.model.WeatherAlert
import java.time.Duration
import java.time.ZonedDateTime

class AlertsMapper {
    fun mapToDomainEntity(response: WeatherAlertsResponseDTO): List<WeatherAlert> =
        response.alerts.map {
            val effective = ZonedDateTime.parse(it.properties.effective)
            val ends = it.properties.ends?.let { endDate -> ZonedDateTime.parse(endDate) }
            WeatherAlert(
                event = it.properties.event,
                senderName = it.properties.senderName,
                effective = effective,
                ends = ends,
                duration = ends?.let { Duration.between(effective, ends) },
            )
        }
}
