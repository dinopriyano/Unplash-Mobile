package com.dino.unsplash.shared

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun ktorEngineModule() = module {
    single {
        createDarwinEngine()
    }
}

fun createDarwinEngine(): HttpClientEngine {
    return Darwin.create()
}