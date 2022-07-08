package com.dino.unsplash.shared.data.remote

import io.ktor.client.*

class PhotoApi(private val httpClient: HttpClient ): PhotoApiClient {
    override suspend fun getPhotos(page: Int, perPage: Int, orderBy: String) {
        TODO("Not yet implemented")
    }
}