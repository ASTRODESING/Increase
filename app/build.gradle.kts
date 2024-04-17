plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.astrodesing.increase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.astrodesing.increase"
        minSdk = 27
        targetSdk = 33
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
        viewBinding = true
    }
    viewBinding{
        enable=true
    }
}

dependencies {
    implementation("com.google.android.gms:play-services-location:21.2.0")
    val roomVersion = "2.6.1"
    val splashScreenVersion = "1.0.1"
    val daggerHiltVersion = "2.51"
    val lifecicleVersion = "2.7.0"
    val activityVersion = "1.8.2"
    val fragmentVersion = "1.6.2"
    val navigationUi = "2.7.7"
    val location ="21.2.0"

    //Splash Creen Dependency
    implementation("androidx.core:core-splashscreen:$splashScreenVersion")
    //Room
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    ksp("com.google.dagger:hilt-android-compiler:2.51")
    //Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecicleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecicleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecicleVersion")
    //Activity
    implementation("androidx.activity:activity-ktx:$activityVersion")
    //Fragment
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationUi")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationUi")
    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navigationUi")
    //
    //Location Tracker
    implementation("com.google.android.gms:play-services-location:$location")



    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}