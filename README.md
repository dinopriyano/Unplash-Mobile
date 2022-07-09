<h1 align="center">
  AEJ : Uplash Mobile
</h1>
<p align="center">
  Practice KMM (Kotlin Multiplatform Mobile).
</p>
<p align="center">
  <a href="http://developer.android.com/index.html"><img alt="Platform" src="https://img.shields.io/badge/platform-Android-green.svg"></a>
  <a href="http://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/kotlin-1.6.20-blue.svg"></a>
  <a href="https://developer.android.com/studio/releases/gradle-plugin"><img alt="Gradle" src="https://img.shields.io/badge/gradle-7.2.1-yellow.svg"></a>
  <a href="https://www.apache.org/licenses/LICENSE-2.0.html"><img alt="License" src="https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square"></a>
</p>

<p align="center">
  <img src="assets/img.png"/>
</p>

## Table of Contents
- [Introduction](#introduction)
- [Requirement](#requirement)
- [Installation](#installation)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [License](#license)

## Introduction

This project is made to practice KMM (Kotlin Multiplatform Mobile).

I use Rest API from [Unsplash API](https://api.unsplash.com) for the data source.

I made it with Clean architecture, Design Pattern, Networking with Ktor, Reactive Programming with Coroutines Flow for Android and Combine for iOS, Dependency Injection with Koin, and many things.

Thank you very much :)

## Requirement

- MacOS (for XCode)
- Android Studio (Recommended Android Studio Chipmunk)
- Kotlin 1.6.20
- XCode (Recommended XCode 13.3.1)
- Cocoapods
- Unsplash Access Key

## Installation

1. Clone or Download and Open it into Android Studio
```
    https://github.com/dinopriyano/Unplash-Mobile
```

2. Install Cocoapods
```
    brew install cocoapods
```

3. Register or login to Unsplash Developer Page
    For the tutorial, read [here](https://unsplash.com/documentation#creating-a-developer-account)

4. Put ur Unsplash Access Key and Secret Key on `local.properties`
```
    unplashAccessKey=PUT_UR_ACCESS_KEY_HERE
    unplashSecretKey=PUT_UR_SECRET_KEY_HERE
```

5. Run iOS App
    - Open /unplash-ios/unplash-ios.xcworkspace with XCode
    - Then run `pod install` using terminal
    - Last, you can build the project

    
## Features
- Get Photos

## Tech Stack
- MVVM (Model-View-ViewModel) Design Pattern
- Clean Architecture (data, domain, presentation)
- Dependency Injection with Koin
- Coroutines Flow
- Combine
- Jetpack Compose
- Safe Loging with Kermit

## License

```
    Copyright (C) Dino Priyano

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```