plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.yomicepa"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.yomicepa"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding= true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    //ViewModel
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:3.14.9")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("androidx.work:work-runtime-ktx:2.7.1")

    //room
    implementation("androidx.room:room-ktx:2.5.1")
    implementation("androidx.room:room-runtime:2.5.1")
    kapt("androidx.room:room-compiler:2.5.0")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.5.3")
    implementation("androidx.navigation:navigation-compose:2.5.3")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

}
