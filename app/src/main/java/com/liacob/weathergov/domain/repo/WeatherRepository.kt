package com.liacob.weathergov.domain.repo

import com.liacob.weathergov.domain.model.WeatherAlert

interface WeatherRepository {
    suspend fun fetchAlerts(): List<WeatherAlert>
}