package com.losingtime.eventhoy.data.repository

import com.losingtime.eventhoy.data.dto.CategoryDto
import com.losingtime.eventhoy.data.mapper.toDomain
import com.losingtime.eventhoy.domain.entity.Category
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess


class ApiService {
    private val client = createHttpClient()

    suspend fun getCategories(): Result<List<Category>> {
        try {
            val response = client.get("https://jsonplaceholder.typicode.com/posts") {
                contentType(ContentType.Application.Json)
            }
            if (response.status.isSuccess()) {
                val body = response.body<List<CategoryDto>>()
                return Result.success(body.map { it.toDomain() })
            } else {
                return Result.failure(Throwable(message = ""))
            }

        } catch (e: ClientRequestException) {
            return Result.failure(e)
        } catch (e: ServerResponseException) {
            return Result.failure(e)
        }

    }

}