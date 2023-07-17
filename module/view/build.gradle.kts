plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    kotlin("kapt")
}

android {
    namespace = namespace("module.view")
    compileSdk = App.compileSdk

    defaultConfig {
        minSdk = App.minSdk
        testInstrumentationRunner = App.testInstrumentationRunner
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = App.javaVersion
        targetCompatibility = App.javaVersion
    }
    kotlinOptions {
        jvmTarget = App.jvmTarget
    }
    buildFeatures{
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":module:domain"))
    appLibraries()
}