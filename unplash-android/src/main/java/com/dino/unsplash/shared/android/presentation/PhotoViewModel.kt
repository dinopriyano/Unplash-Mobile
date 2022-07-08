package com.dino.unsplash.shared.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dino.unsplash.shared.domain.PhotoUseCase
import com.dino.unsplash.shared.domain.model.Photo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import com.dino.unsplash.shared.android.utils.Result as Result

class PhotoViewModel(private val useCase: PhotoUseCase): ViewModel() {

    private val _photos = MutableStateFlow<Result<List<Photo>>>(Result())
    val photos: StateFlow<Result<List<Photo>>> = _photos.asStateFlow()

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            _photos.value = Result.loading()

            useCase.getPhotos(1, 10, "latest")
                .catch { cause: Throwable ->
                    _photos.value = Result.failed(cause)
                }
                .collect { result ->
                    if(result.isNotEmpty()) {
                        _photos.value = Result.success(result)
                    }
                    else {
                        _photos.value = Result.empty()
                    }
                }
        }
    }

}