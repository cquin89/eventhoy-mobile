package com.losingtime.eventhoy.domain.usecase

import com.losingtime.eventhoy.domain.EventRepository
import com.losingtime.eventhoy.domain.entity.Event
import com.losingtime.eventhoy.domain.entity.PaginatedResult

class GetFilteredEventsUseCase(
    private val repository: EventRepository
) {
    suspend operator fun invoke(
        page: Int,
        pageSize: Int,
        title: String? = null,
        categoryId: String? = null,
        startDate: String? = null,
        endDate: String? = null,
        latitude: Double? = null,
        longitude: Double? = null,
        radiusKm: Double? = null
    ): Result<PaginatedResult<Event>> {
        return repository.getEvents(
            page = page,
            pageSize = pageSize,
            title = title,
            categoryId = categoryId,
            startDate = startDate,
            endDate = endDate,
            latitude = latitude,
            longitude = longitude,
            radiusKm = radiusKm

        )
    }
}