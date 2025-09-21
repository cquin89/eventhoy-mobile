package com.losingtime.eventhoy.data.repository

import io.ktor.client.HttpClient

import io.ktor.client.engine.darwin.*

actual fun httpClient(): HttpClient = HttpClient(Darwin) {
    // Configuración extra para Darwin (NSURLSession debajo)
    engine {
        configureRequest {
            setAllowsCellularAccess(true)
        }
    }
}