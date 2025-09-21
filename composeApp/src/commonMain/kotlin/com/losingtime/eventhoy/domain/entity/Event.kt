package com.losingtime.eventhoy.domain.entity

data class Event(
    val id: String,
    val name: String,
    val categoryId: String,
    val latitude: Double,
    val longitude: Double,
    val date: String
)