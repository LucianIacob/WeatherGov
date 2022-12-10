package com.liacob.weathergov.domain

import com.liacob.weathergov.data.repo.WeatherRepositoryImpl
import com.liacob.weathergov.domain.repo.WeatherRepository

class FetchWeatherAlertsUseCase(
    private val repository: WeatherRepository = WeatherRepositoryImpl(),
) {
    suspend fun doWork() = repository.fetchAlerts()
}
