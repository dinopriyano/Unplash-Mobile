package com.dino.unsplash.shared.di.feature

import com.dino.unsplash.shared.data.PhotoDataStore
import com.dino.unsplash.shared.data.PhotoRepository
import com.dino.unsplash.shared.domain.PhotoInteractor
import com.dino.unsplash.shared.domain.PhotoUseCase
import org.koin.dsl.module

val photoModule = module {
    single<PhotoRepository> { PhotoDataStore(get()) }
    single<PhotoUseCase> { PhotoInteractor(get()) }
}