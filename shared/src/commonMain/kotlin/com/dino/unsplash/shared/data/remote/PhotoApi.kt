package com.dino.unsplash.shared.data.remote

import com.dino.unsplash.shared.BuildKonfig
import com.dino.unsplash.shared.Configs
import com.dino.unsplash.shared.data.model.response.PhotoItem
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class PhotoApi(private val httpClient: HttpClient ): PhotoApiClient {
    override suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem> {
        return httpClient.get(Configs.BASE_URL.plus("/photos")) {
            parameter("client_id", BuildKonfig.ACCESS_KEY)
            parameter("page", page)
            parameter("per_page", perPage)
            parameter("order_by", orderBy)
        }.body()
    }
}