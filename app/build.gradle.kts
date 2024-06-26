plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.jetbrains.kotlin.android)
  alias(libs.plugins.org.jetbrains.kotlin.kapt)
  id("com.google.dagger.hilt.android")
  id("kotlin-parcelize")
}

android {
  namespace = "com.example.expense_tracker_app"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.example.expense_tracker_app"
    minSdk = 26
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
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
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.14"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation(libs.androidx.material.icons.core)
  implementation(libs.androidx.material.icons.extended)

  implementation(libs.androidx.navigation.compose)

  implementation(libs.androidx.room.runtime.v242)
  implementation(libs.androidx.runtime.livedata)
  kapt(libs.androidx.room.compiler.v242)
  implementation(libs.androidx.room.ktx.v242)

  implementation(libs.androidx.hilt.navigation.compose)

  implementation(libs.landscapist.coil3)
  implementation(libs.hilt.android)
  implementation(libs.androidx.material3.android)
  implementation(libs.androidx.tools.core)
  kapt(libs.hilt.android.compiler)
  implementation(libs.androidx.room.runtime)
  kapt(libs.androidx.room.compiler)
  implementation(libs.androidx.room.ktx)
  implementation (libs.coil.compose.v100)
  implementation(libs.coil.compose)
  implementation(libs.gson)
  implementation(libs.androidx.lifecycle.livedata.ktx)
  implementation(libs.androidx.lifecycle.viewmodel.ktx)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)
}

kapt {
  correctErrorTypes = true
}
