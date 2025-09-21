package com.losingtime.eventhoy.presentation.screen.home

import com.losingtime.eventhoy.domain.entity.Category

data class HomeUiState(
    val isLoading: Boolean = false,
    val category: List<Category>
)


