//
//  Error.swift
//  unplash-ios
//
//  Created by Dino Priyano on 09/07/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Shared

extension Error {
  var apiError: ApiError? {
    (self as NSError).userInfo["KotlinException"] as? ApiError
  }
}
