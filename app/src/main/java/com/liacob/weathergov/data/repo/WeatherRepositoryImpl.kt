package com.liacob.weathergov.data.repo

import com.liacob.weathergov.data.mapper.AlertsMapper
import com.liacob.weathergov.data.source.GovDataSource
import com.liacob.weathergov.domain.model.WeatherAlert
import com.liacob.weathergov.domain.repo.WeatherRepository

class WeatherRepositoryImpl(
    private val dataSource: GovDataSource = GovDataSource(),
    private val mapper: AlertsMapper = AlertsMapper(),
) : WeatherRepository {

    override suspend fun fetchAlerts(): List<WeatherAlert> {
        val response = dataSource.fetchAlerts()
        return mapper.mapToDomainEntity(response)
    }
}
