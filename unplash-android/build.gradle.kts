plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("kotlin-android")
    id("com.google.devtools.ksp") version "1.7.0-1.0.6"
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.dino.unsplash.shared.android"
        minSdk = 22
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    implementation("androidx.navigation:navigation-fragment-ktx:2.4.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")

    implementation("androidx.compose.ui:ui:1.3.0-alpha01")
    implementation("androidx.compose.material:material:1.3.0-alpha01")
    implementation("androidx.compose.ui:ui-tooling:1.3.0-alpha01")
    implementation("androidx.compose.foundation:foundation:1.3.0-alpha01")
    implementation("androidx.compose.foundation:foundation-layout:1.3.0-alpha01")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.17.0")
    implementation("androidx.compose.ui:ui-graphics:1.3.0-alpha01")
    implementation("androidx.activity:activity-compose:1.5.0")
    implementation("androidx.compose.material:material-icons-extended:1.3.0-alpha01")
    implementation("androidx.compose.ui:ui-util:1.3.0-alpha01")
    implementation("com.valentinilk.shimmer:compose-shimmer:1.0.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.3.0-alpha01")

    implementation("io.insert-koin:koin-android:3.1.6")
    implementation("io.insert-koin:koin-androidx-compose:3.1.6")

    implementation("com.google.accompanist:accompanist-coil:0.15.0")

    implementation("io.github.raamcosta.compose-destinations:core:1.5.12-beta")
    implementation("io.github.raamcosta.compose-destinations:animations-core:1.5.12-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.5.12-beta")
}