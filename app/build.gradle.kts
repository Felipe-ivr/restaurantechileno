plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.restauranteapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.restauranteapp"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    // Asegúrate de que tanto Kotlin como Java usen la misma versión de JVM
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"  // Usar 1.8 para Kotlin, igual que Java
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false  // Deshabilita la minificación en el modo release
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
