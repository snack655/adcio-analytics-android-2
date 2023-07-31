plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
    id(Plugins.ktlint) version Versions.KTLINT
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = AppConfig.appNamespace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = AppConfig.useSupportLibrary
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = AppConfig.minifyEnabled
            proguardFiles(
                getDefaultProguardFile(AppConfig.defaultProguardFile),
                AppConfig.proguardConsumerRules
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures {
        compose = AppConfig.compose
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += AppConfig.packagingOption
        }
    }
}

dependencies {

    implementation(Libraries.androidLibraries)
    implementation(Libraries.composeLibraries)
    implementation(platform(Libraries.composeBom))
    implementation(Libraries.coroutineLibraries)
    implementation(Libraries.networkLibraries)
    implementation("com.google.firebase:firebase-crashlytics:18.4.0")
    implementation("com.google.firebase:firebase-analytics:21.3.0")

    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.testLibraries)
    androidTestImplementation(platform(Libraries.composeBom))
    debugImplementation(Libraries.debugLibraries)

    implementation(project(AppConfig.pathOfAnalytics))
}
