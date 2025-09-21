package com.losingtime.eventhoy.domain

import com.losingtime.eventhoy.domain.entity.Category
import com.losingtime.eventhoy.domain.entity.Event
import com.losingtime.eventhoy.domain.entity.PaginatedResult

interface EventRepository {
    suspend fun getEvents(
        page: Int,
        pageSize: Int,
        title: String? = null,
        categoryId: String? = null,
        startDate: String? = null,
        endDate: String? = null,
        latitude: Double? = null,
        longitude: Double? = null,
        radiusKm: Double? = null
    ): Result<PaginatedResult<Event>>

    suspend fun getCategories(): Result<List<Category>>
}