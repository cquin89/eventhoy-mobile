package com.losingtime.eventhoy.domain.usecase

import com.losingtime.eventhoy.domain.EventRepository
import com.losingtime.eventhoy.domain.entity.Category

class GetCategoriesUseCase(
    private val repository: EventRepository
) {
    suspend operator fun invoke(): Result<List<Category>> {
        return repository.getCategories()
    }
}