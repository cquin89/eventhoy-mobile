package com.losingtime.eventhoy.data.dto

data class EventDto(
    val id: String,
    val title: String,
    val categoryId: String,
    val latitude: Double,
    val longitude: Double,
    val date: String
)