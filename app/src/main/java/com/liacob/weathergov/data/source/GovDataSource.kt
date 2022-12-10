package com.liacob.weathergov.data.source

import com.liacob.weathergov.data.model.WeatherAlertsResponseDTO
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class GovDataSource {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 3)
            exponentialDelay()
        }
    }

    suspend fun fetchAlerts() =
        httpClient
            .get(urlString = "https://api.weather.gov/alerts/active?status=actual&message_type=alert")
            .body<WeatherAlertsResponseDTO>()
}
