plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlinx-serialization")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kotlin.sourceSets.all {
        languageSettings.optIn("kotlin.RequiresOptIn")
    }
}

dependencies {
    implementation(platform(Libs.OKHTTP_BOM))
    implementation(Libs.OKHTTP)
    implementation(Libs.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Libs.RETROFIT2)

    implementation(Libs.KOTLINX_SERIALIZATION_JSON)
    implementation(Libs.KOTLINX_SERIALIZATION_CONVERTER)

    implementation(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)
}