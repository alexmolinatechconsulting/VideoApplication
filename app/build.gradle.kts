import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

var properties = Properties()
var baseUrl : String = ""
var baseImageUrl : String = ""
var endpointVideo : String = ""
var apiKey : String = ""
var bearerToken : String = ""

if (File("local.properties").exists()) {
    properties = Properties().apply { load(project.rootProject.file("local.properties").inputStream()) }
    baseUrl = properties.getProperty("BASE_URL")
    baseImageUrl = properties.getProperty("BASE_IMAGE_URL")
    endpointVideo = properties.getProperty("ENDPOINT_VIDEO")
    apiKey = properties.getProperty("API_KEY")
    bearerToken = properties.getProperty("BEARER_TOKEN")
}

android {
    namespace = "com.videoapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.videoapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        buildConfig = true
    }
    buildTypes {
        debug{
            buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
            buildConfigField("String", "BASE_IMAGE_URL", "\"$baseImageUrl\"")
            buildConfigField("String", "ENDPOINT_VIDEO", "\"$endpointVideo\"")
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
            buildConfigField("String", "BEARER_TOKEN", "\"$bearerToken\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
            buildConfigField("String", "BASE_IMAGE_URL", "\"$baseImageUrl\"")
            buildConfigField("String", "ENDPOINT_VIDEO", "\"$endpointVideo\"")
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
            buildConfigField("String", "BEARER_TOKEN", "\"$bearerToken\"")
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("com.google.firebase:firebase-firestore:24.10.1")
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation(platform("com.google.firebase:firebase-bom:32.7.1"))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
}