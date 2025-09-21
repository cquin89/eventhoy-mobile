package com.losingtime.eventhoy.data

import com.losingtime.eventhoy.data.repository.ApiService
import com.losingtime.eventhoy.domain.EventRepository
import com.losingtime.eventhoy.domain.entity.Category
import com.losingtime.eventhoy.domain.entity.Event
import com.losingtime.eventhoy.domain.entity.PaginatedResult

class EventRepositoryImpl : EventRepository {
    override suspend fun getEvents(
        page: Int,
        pageSize: Int,
        title: String?,
        categoryId: String?,
        startDate: String?,
        endDate: String?,
        latitude: Double?,
        longitude: Double?,
        radiusKm: Double?
    ): Result<PaginatedResult<Event>> {
        return Result.success(
            PaginatedResult(
                items = listOf(
                    Event(
                        id = "1",
                        name = "2",
                        categoryId = "1",
                        latitude = 1.1,
                        longitude = 1.1,
                        date = ""
                    )
                ), 1, 2, 2
            )
        )
    }

    override suspend fun getCategories(): Result<List<Category>> {
        return ApiService().getCategories()
    }


}