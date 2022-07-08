package com.dino.unsplash.shared.domain

import com.dino.unsplash.shared.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoUseCase {
    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): Flow<List<Photo>>
}