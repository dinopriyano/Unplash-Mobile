package com.dino.unsplash.shared.android

import android.app.Application
import com.dino.unsplash.shared.android.di.viewModelModule
import com.dino.unsplash.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@BaseApplication)
            modules(viewModelModule())
        }
    }

}