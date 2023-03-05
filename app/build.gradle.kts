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
    androidTestImplementation (Deps.EXT_JUNIT)
    androidTestImplementation (Deps.ESPRESSO)

    implementation (project(":common"))
    implementation (project(":data"))
    implementation (project(":domain"))
    implementation (project(":network"))
    implementation (project(":presentation"))

    // Dagger - Hilt
    implementation(Deps.DAGGER_HILT)
    kapt(Deps.DAGGER_HILT_COMPILER)

    // Navigation Component
    implementation(Deps.NAVIGATION_FRAGMENT)
    implementation(Deps.NAVIGATION_UI)

    // Glide
    implementation (Deps.GLIDE)
    kapt (Deps.GLIDE_COMPILER)

//    // Architectural Components
//    implementation (Deps.LIFECYCLE_VIEW_MODEL)
}

kapt {
    correctErrorTypes = true
}