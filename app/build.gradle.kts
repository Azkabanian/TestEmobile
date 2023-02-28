plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.iusupov.testemobile"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.iusupov.testemobile"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        android.buildFeatures.viewBinding = true
    }
}

dependencies {
    implementation (Deps.CORE)
    implementation (Deps.APPCOMPAT)
    implementation (Deps.MATERIAL)
    implementation (Deps.CONSTRAINTLAYOUT)
    implementation(Deps.CONSTRAINTLAYOUT)
    testImplementation (Deps.JUNIT)
    androidTestImplementation (Deps.EXTJUNIT)
    androidTestImplementation (Deps.ESPRESSO)

    // Dagger - Hilt
    implementation(Deps.DAGGER_HILT)
    kapt(Deps.DAGGER_HILT_COMPILER)
}

kapt {
    correctErrorTypes = true
}