plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android") // Plugin de Hilt
    kotlin("kapt") // Para habilitar KAPT (Kotlin Annotation Processing)
}

android {
    namespace = "com.android.todoapp2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.android.todoapp2"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Necesario para Hilt
        javaCompileOptions {
            annotationProcessorOptions {
                arguments["dagger.hilt.android.internal.disableAndroidSuperclassValidation"] = "true"
            }
        }
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Dependencias existentes
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Dependencias de Hilt
    implementation(libs.hilt.android) // Usa la última versión de Hilt
    implementation(libs.androidx.hilt.work)
    // When using Kotlin. // When using Java.
    annotationProcessor(libs.androidx.hilt.compiler.v100)
    kapt(libs.androidx.hilt.compiler)
    kapt(libs.hilt.android.compiler)

}

// Necesario para habilitar el plugin de Hilt
kapt {
    correctErrorTypes = true
}
