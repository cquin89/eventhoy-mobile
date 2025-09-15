package com.losingtime.eventhoy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform