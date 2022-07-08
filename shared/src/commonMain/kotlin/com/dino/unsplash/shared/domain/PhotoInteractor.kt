package com.dino.unsplash.shared.domain

import com.dino.unsplash.shared.data.PhotoRepository

class PhotoInteractor(private val repository: PhotoRepository): PhotoUseCase {
}