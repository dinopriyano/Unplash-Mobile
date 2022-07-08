package com.dino.unsplash.shared.data

import com.dino.unsplash.shared.data.model.response.PhotoItem

interface PhotoRepository {
    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem>
}