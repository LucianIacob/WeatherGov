package com.liacob.weathergov.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liacob.weathergov.domain.FetchWeatherAlertsUseCase
import com.liacob.weathergov.domain.model.WeatherAlert
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class WeatherListViewModel(
    private val useCase: FetchWeatherAlertsUseCase = FetchWeatherAlertsUseCase(),
) : ViewModel() {

    private val _errors = Channel<Exception>(Channel.BUFFERED)
    private val _weatherAlerts = MutableStateFlow<List<WeatherAlert>>(emptyList())
    private val _isLoading = MutableStateFlow(false)

    val weatherAlerts = _weatherAlerts.asStateFlow()
    val isLoading = _isLoading.asStateFlow()
    val errors = _errors.receiveAsFlow()

    init {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _weatherAlerts.value = useCase.doWork()
            } catch (ex: Exception) {
                _errors.send(ex)
            }
            _isLoading.value = false
        }
    }
}
