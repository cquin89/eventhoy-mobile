package com.losingtime.eventhoy.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.losingtime.eventhoy.data.EventRepositoryImpl
import com.losingtime.eventhoy.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val getCategoriesUseCase = GetCategoriesUseCase(EventRepositoryImpl())
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
       loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            getCategoriesUseCase()
                    .fold(
                            onSuccess = { categories ->
                                _uiState.value =
                                        _uiState.value.copy(
                                                isLoading = false,
                                                categories = categories,
                                                error = null
                                        )
                            },
                            onFailure = { error ->
                                _uiState.value =
                                        _uiState.value.copy(
                                                isLoading = false,
                                                categories = emptyList(),
                                                error = error.message
                                                                ?: "Error al cargar categorías"
                                        )
                            }
                    )
        }
    }

    fun retryLoadCategories() {
        loadCategories()
    }
}
