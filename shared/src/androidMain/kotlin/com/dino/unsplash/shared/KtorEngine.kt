package com.dino.unsplash.shared

import io.ktor.client.engine.android.*
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun ktorEngineModule() = module {
    single {
        Android.create()
    }
}