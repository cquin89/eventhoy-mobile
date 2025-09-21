package com.losingtime.eventhoy.di

import com.losingtime.eventhoy.data.EventRepositoryImpl
import com.losingtime.eventhoy.data.repository.ApiService
import com.losingtime.eventhoy.domain.EventRepository
import com.losingtime.eventhoy.domain.usecase.GetCategoriesUseCase
import com.losingtime.eventhoy.domain.usecase.GetFilteredEventsUseCase
import com.losingtime.eventhoy.presentation.screen.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // API Service
    single { ApiService() }

    // Repository
    single<EventRepository> { EventRepositoryImpl(get()) }

    // Use Cases
    single { GetCategoriesUseCase(get()) }
    single { GetFilteredEventsUseCase(get()) }

    // ViewModels
    viewModel { HomeViewModel(get()) }
}
