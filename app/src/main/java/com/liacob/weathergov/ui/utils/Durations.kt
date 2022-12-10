package com.liacob.weathergov.ui.utils

import java.time.Duration
import java.util.concurrent.TimeUnit

fun Duration.asDisplayable(): String = when {
    toDays() > 0 -> {
        String.format("%sd %sh %sm",
            toDays(),
            toHours() - TimeUnit.DAYS.toHours(toDays()),
            toMinutes() - TimeUnit.HOURS.toMinutes(toHours()))
    }
    toHours() > 0 -> {
        String.format("%sh %sm", toHours() - TimeUnit.DAYS.toHours(toDays()), toMinutes() - TimeUnit.HOURS.toMinutes(toHours()))
    }
    else -> {
        String.format("%sm", toMinutes() - TimeUnit.HOURS.toMinutes(toHours()))
    }
}
