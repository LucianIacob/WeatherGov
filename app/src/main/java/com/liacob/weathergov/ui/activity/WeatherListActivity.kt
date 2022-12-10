package com.liacob.weathergov.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liacob.weathergov.R
import com.liacob.weathergov.ui.adapter.AlertsAdapter
import com.liacob.weathergov.ui.viewmodel.WeatherListViewModel
import kotlinx.coroutines.launch

class WeatherListActivity : AppCompatActivity() {

    private val viewModel: WeatherListViewModel by viewModels()
    private val alertsAdapter by lazy { AlertsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)

        findViewById<RecyclerView>(R.id.alertsList).apply {
            layoutManager = LinearLayoutManager(this@WeatherListActivity)
            adapter = alertsAdapter
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.errors.collect {
                    findViewById<View>(R.id.errorView).isVisible = true
                    // any other error handling
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isLoading.collect {
                    findViewById<View>(R.id.loadingView).isVisible = it
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.weatherAlerts.collect { alertsAdapter.items = it }
            }
        }
    }
}
