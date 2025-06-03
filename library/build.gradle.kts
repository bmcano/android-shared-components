plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.compose)
    id("maven-publish")
}

group = "com.github.bmcano"
version = "1.7.1"

android {
    namespace = "com.brandoncano.sharedcomponents"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        version = "1.7.1"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // AndroidX
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.core.ktx)

    // AndroidX.Compose
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material.icons)
    implementation(libs.androidx.compose.runtime.livedata)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    // AndroidX.Navigation
    implementation(libs.androidx.navigation.compose)

    // Test
    testImplementation(libs.mockk)
    testImplementation(libs.junit)

    // Google
    implementation(libs.billing.client)
    implementation(libs.gson)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.github.bmcano"
                artifactId = "shared-android-components"
                version = "1.7.1"
                from(components.findByName("release"))
            }
        }
    }
}
