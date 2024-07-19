package br.com.cat

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class HttpClientService {

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 2)
            exponentialDelay()
        }

        expectSuccess = true
    }

    suspend inline fun <reified T> get(
        url: String,
        headers: Map<String, String> = emptyMap(),
        queryParams: Map<String, String> = emptyMap()
    ): T {
        return client.get(url) {
            headers.forEach { (key, value) ->
                header(key, value)
            }
            queryParams.forEach { (key, value) ->
                parameter(key, value)
            }
        }.body()
    }

    suspend inline fun <reified T, reified R> post(
        url: String,
        body: R,
        headers: Map<String, String> = emptyMap(),
        queryParams: Map<String, String> = emptyMap()
    ): T {
        return client.post(url) {
            headers.forEach { (key, value) ->
                header(key, value)
            }
            queryParams.forEach { (key, value) ->
                parameter(key, value)
            }
            contentType(ContentType.Application.Json)
            setBody(body)
        }.body()
    }

    fun close() {
        client.close()
    }
}