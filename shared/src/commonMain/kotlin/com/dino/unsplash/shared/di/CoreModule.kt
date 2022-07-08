package com.dino.unsplash.shared.di

import com.dino.unsplash.shared.data.model.response.ApiException
import com.dino.unsplash.shared.data.remote.PhotoApi
import com.dino.unsplash.shared.data.remote.PhotoApiClient
import com.dino.unsplash.shared.di.feature.photoModule
import com.dino.unsplash.shared.ktorEngineModule
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    return startKoin {
        appDeclaration()
        modules(
            remoteModule,
            ktorEngineModule(),
            photoModule
        )
    }
}

//init koin for iOS
fun initKoin() = initKoin {

}

val remoteModule = module {
    single<PhotoApiClient> { PhotoApi(get()) }
    single {
        //json
        createJson()
    }
    single {
        //http client
        createHttpClient(get(), get())
    }
}

fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

fun createHttpClient(httpClientEngine: HttpClientEngine, json: Json) = HttpClient(httpClientEngine) {
    install(ContentNegotiation) {
         json(json = json)
    }

    install(HttpTimeout) {
        this.requestTimeoutMillis = 60000
        this.connectTimeoutMillis = 60000
        this.socketTimeoutMillis = 60000
    }

    HttpResponseValidator {
        handleResponseExceptionWithRequest { exception, _ ->
            when(exception) {
                is ServerResponseException -> {
                    val serverResponseExceptionResponse = exception.response
                    val serverResponseExceptionText = serverResponseExceptionResponse.bodyAsText()
                    val apiException = json.decodeFromString(ApiException.serializer(), serverResponseExceptionText)
                    throw apiException
                }
                is ClientRequestException -> {
                    val clientRequestExceptionResponse = exception.response
                    val clientRequestExceptionText = clientRequestExceptionResponse.bodyAsText()
                    val apiException = json.decodeFromString(ApiException.serializer(), clientRequestExceptionText)
                    throw apiException
                }
                else -> return@handleResponseExceptionWithRequest
            }
        }
    }
}