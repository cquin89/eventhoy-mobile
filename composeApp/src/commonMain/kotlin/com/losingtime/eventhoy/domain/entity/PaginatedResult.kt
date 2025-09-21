package com.losingtime.eventhoy.domain.entity


data class PaginatedResult<T>(
    val items: List<T>,
    val page: Int,
    val totalPages: Int,
    val totalItems: Int
)