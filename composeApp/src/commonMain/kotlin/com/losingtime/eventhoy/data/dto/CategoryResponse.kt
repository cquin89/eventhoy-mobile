package com.losingtime.eventhoy.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(val data:List<CategoryDto>)