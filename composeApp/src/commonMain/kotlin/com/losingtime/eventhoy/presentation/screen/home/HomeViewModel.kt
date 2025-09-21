package com.losingtime.eventhoy.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.losingtime.eventhoy.data.EventRepositoryImpl
import com.losingtime.eventhoy.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    val getCategoriesUseCase = GetCategoriesUseCase(EventRepositoryImpl())
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
}