package com.dino.unsplash.shared.android.di

import com.dino.unsplash.shared.android.presentation.PhotoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel{ PhotoViewModel(get()) }
}