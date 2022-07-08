package com.dino.unsplash.shared.domain

import com.dino.unsplash.shared.data.PhotoRepository
import com.dino.unsplash.shared.domain.base.execute
import com.dino.unsplash.shared.domain.mapper.map
import com.dino.unsplash.shared.domain.model.Photo
import kotlinx.coroutines.flow.Flow

class PhotoInteractor(private val repository: PhotoRepository): PhotoUseCase {
    override suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): Flow<List<Photo>> {
        return execute {
            repository.getPhotos(page, perPage, orderBy).map {
                it.map()
            }
        }
    }
}