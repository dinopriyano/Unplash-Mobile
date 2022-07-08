package com.dino.unsplash.shared.data

import com.dino.unsplash.shared.data.remote.PhotoApiClient

class PhotoDataStore(private val apiClient: PhotoApiClient): PhotoRepository {
}