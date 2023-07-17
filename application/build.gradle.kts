plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    kotlin("kapt")
}

android {
    namespace = namespace("app")
    compileSdk = App.compileSdk

    defaultConfig {
        applicationId = App.namespace
        minSdk = App.minSdk
        targetSdk = App.targetSdk
        versionCode = App.appVersionCode(gradle)
        versionName = App.versionName

        testInstrumentationRunner = App.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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

    appLibraries()
    implementation(project(":module"))
}