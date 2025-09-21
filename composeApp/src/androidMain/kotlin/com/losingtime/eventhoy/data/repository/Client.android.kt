package com.losingtime.eventhoy.data.repository

import io.ktor.client.HttpClient

import io.ktor.client.engine.okhttp.*

actual fun httpClient(): HttpClient = HttpClient(OkHttp) {
    // Opciones adicionales específicas de Android/OkHttp
    engine {
        // Ejemplo: timeouts
        config {
            followRedirects(true)
        }
    }
}