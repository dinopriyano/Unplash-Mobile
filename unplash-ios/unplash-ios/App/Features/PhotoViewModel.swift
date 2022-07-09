//
//  PhotoViewModel.swift
//  unplash-ios
//
//  Created by Dino Priyano on 09/07/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import KMPNativeCoroutinesCombine
import Combine
import Shared


class PhotoViewModel: ObservableObject {
    
    @Published var photos: ViewState<[Photo]> = .initiate
    
    private let photoUseCase: PhotoUseCase
    private var cancellable = Set<AnyCancellable>()
    
    init(photoUseCase: PhotoUseCase) {
        self.photoUseCase = photoUseCase
    }
    
    func getPhotos() {
        photos = .loading
        createPublisher(for: photoUseCase.getPhotosNative(page: 1, perPage: 10, orderBy: "latest"))
            .receive(on: DispatchQueue.main)
            .sink { completion in
                switch completion {
                case .finished: ()
                case .failure(let error):
                    self.photos = .error(error: error)
                }
            } receiveValue: { value in
                self.photos = .success(data: value)
            }.store(in: &cancellable)
    }
}
