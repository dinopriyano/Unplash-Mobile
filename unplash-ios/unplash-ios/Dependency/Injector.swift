//
//  Injector.swift
//  unplash-ios
//
//  Created by Dino Priyano on 09/07/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Shared

typealias HttpClient = Ktor_client_coreHttpClient

struct Injector {
    static func injectViewModel() -> PhotoViewModel {
        return PhotoViewModel(photoUseCase: injectUseCase())
    }
    
    static func injectUseCase() -> PhotoUseCase {
        return PhotoInteractor(repository: injectRepository())
    }
    
    static func injectRepository() -> PhotoRepository {
        return PhotoDataStore(apiClient: injectApiClient())
    }
    
    static func injectApiClient() -> PhotoApiClient {
        return PhotoApi(httpClient: injectHttpClient())
    }
    
    static func injectHttpClient() -> HttpClient {
        return CoreModuleKt.createHttpClient(httpClientEngine: KtorEngineKt.createDarwinEngine(), json: CoreModuleKt.createJson())
    }
}
