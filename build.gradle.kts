buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("io.insert-koin:koin-gradle-plugin:3.1.4")
        classpath("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:0.12.0")
        classpath("io.realm.kotlin:gradle-plugin:1.0.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}