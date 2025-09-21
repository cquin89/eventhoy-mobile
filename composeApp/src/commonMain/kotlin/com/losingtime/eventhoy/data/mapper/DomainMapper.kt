package com.losingtime.eventhoy.data.mapper

import com.losingtime.eventhoy.data.dto.CategoryDto
import com.losingtime.eventhoy.data.dto.EventDto
import com.losingtime.eventhoy.data.dto.PaginatedResponse
import com.losingtime.eventhoy.domain.entity.Category
import com.losingtime.eventhoy.domain.entity.Event
import com.losingtime.eventhoy.domain.entity.PaginatedResult

fun EventDto.toDomain(): Event = Event(
    id = id,
    name = title,
    categoryId = categoryId,
    latitude = latitude,
    longitude = longitude,
    date = date
)

fun CategoryDto.toDomain(): Category = Category(
    id = id,
    name = name
)

fun PaginatedResponse<EventDto>.toDomain(): PaginatedResult<Event> =
    PaginatedResult(
        items = data.map { it.toDomain() },
        page = page,
        totalPages = totalPages,
        totalItems = totalItems
    )