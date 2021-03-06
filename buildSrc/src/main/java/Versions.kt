/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Versions {
    const val versionName = "1.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    private const val versionCodeBase = 100110 // XYYZZM; M = Module (tv, mobile)
    const val versionCodeMobile = versionCodeBase + 1

    const val COMPILE_SDK = 32
    const val TARGET_SDK = 32
    const val MIN_SDK = 21

    const val ANDROID_GRADLE_PLUGIN = "7.0.0-beta05"
    const val BENCHMARK = "1.0.0"
    const val COMPOSE = "1.0.0-beta04"
    const val FIREBASE_CRASHLYTICS = "2.3.0"
    const val GOOGLE_SERVICES = "4.3.3"
    const val KOTLIN = "1.4.32"
    const val HILT_AGP = "2.41"
    const val CONSTRAINT_LAYOUT = "2.1.3"
    const val APPCOMPAT = "1.4.1"
    const val CORE_KTX = "1.7.0"
    const val MATERIAL = "1.7.0-alpha01"
    const val JUNIT = "4.13.2"
    const val EXT_JUNIT = "1.1.3"
    const val ESPRESSO_CORE = "3.4.0"
    const val LIFECYCLE_VIEW_MODEL_KTX = "2.4.1"
    const val NAVIGATION_FRAGMENT_KTX = "2.4.1"
    const val LIFECYCLE_LIVE_DATA_KTX = "2.4.1"
    const val NAVIGATION_UI_KTX = "2.4.1"
    const val OKHTTP = "4.9.3"
    const val OKHTTP_BOM = "4.9.3"
    const val RETROFIT2 = "2.9.0"
    const val KOTLINX_SERIALIZATION_JSON = "1.2.2"
    const val KOTLINX_SERIALIZATION_CONVERTER = "0.8.0"
    const val COROUTINES = "1.6.1"
    const val EPOXY = "4.6.3"
    const val GLIDE = "4.13.0"
    const val SWIPEREFRESH_LAYOUT = "1.1.0"
    const val ROOM = "2.4.2"
    const val ROOM_PAGING3 = "2.5.0-alpha01"
    const val PAGING3_RUNTIME = "3.1.1"
    const val TIMBER = "5.0.1"
}
