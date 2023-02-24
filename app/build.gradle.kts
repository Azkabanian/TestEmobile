plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
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
}

dependencies {
    implementation (Deps.core)
    implementation (Deps.appcompat)
    implementation (Deps.material)
    implementation (Deps.constraintlayout)
    implementation(Deps.constraintlayout)
    testImplementation (Deps.junit)
    androidTestImplementation (Deps.extJunit)
    androidTestImplementation (Deps.espresso)
}