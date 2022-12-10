package com.liacob.weathergov.ui.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun ZonedDateTime.asDisplayable(): String {
    val formatter = DateTimeFormatter.ofPattern("MMM dd, h:mm a, zzzz")
    return format(formatter)
}
