plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":core:network"))
    implementation(project(":core:utilities"))
    implementation(project(":core:ui"))

    implementation(Libs.CORE_KTX)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_KTX)
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.NAVIGATION_UI_KTX)

    implementation(platform(Libs.OKHTTP_BOM))
    implementation(Libs.OKHTTP)
    implementation(Libs.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Libs.RETROFIT2)

    implementation(Libs.KOTLINX_SERIALIZATION_JSON)

    implementation(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)

    implementation(Libs.EPOXY)
    implementation(Libs.EPOXY_DATA_BINDING)
    kapt(Libs.EPOXY_PROCESSOR)

    implementation(Libs.GLIDE)
    kapt(Libs.GLIDE_COMPILER)

    testImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.EXT_JUNIT)
    androidTestImplementation(Libs.ESPRESSO_CORE)
}