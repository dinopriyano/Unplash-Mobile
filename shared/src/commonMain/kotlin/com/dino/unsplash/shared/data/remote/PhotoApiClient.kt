package com.dino.unsplash.shared.data.remote

interface PhotoApiClient {

    suspend fun getPhotos(
        page: Int,
        perPage: Int,
        orderBy: String
    )

}