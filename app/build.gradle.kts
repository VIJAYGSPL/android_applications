plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.vijay.java_practice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.vijay.java_practice"
        minSdk = 32
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildToolsVersion = "34.0.0"

    buildFeatures {
        dataBinding = true
    }

    }

dependencies {
    implementation ("jakarta.activation:jakarta.activation-api:1.2.1") {
        exclude("com.sun.activation","javax.activation")
        isTransitive = true
    }

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
}