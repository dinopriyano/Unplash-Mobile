package com.dino.unsplash.shared.data.remote

import com.dino.unsplash.shared.data.model.response.PhotoItem

interface PhotoApiClient {

    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem>

}