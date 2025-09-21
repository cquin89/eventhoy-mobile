package com.losingtime.eventhoy.data.dto

// Para la paginación
data class PaginatedResponse<T>(
    val data: List<T>,
    val page: Int,
    val totalPages: Int,
    val totalItems: Int
)