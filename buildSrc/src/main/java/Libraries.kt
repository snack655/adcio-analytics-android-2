import org.gradle.api.artifacts.dsl.DependencyHandler

object Libraries {

    // android
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val lifecycleRunTimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRunTimeKtx}"

    // compose
    private val activityCompose = "androidx.activity:activity-compose:${Versions.compose}"
    private val composeUi = "androidx.compose.ui:ui"
    private val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    private val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    private val composeMaterial3 = "androidx.compose.material3:material3"
    val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"

    // network
    private val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    private val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    // coroutine
    private val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    private val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    // test
    val junit = "junit:junit:${Versions.junit}"
    private val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    private val composeUiTestJunit4 = "androidx.compose.ui:ui-test-junit4"

    // debug
    private val composeUiTooling = "androidx.compose.ui:ui-tooling"
    private val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"

    val androidLibraries = arrayListOf<String>().apply {
        add(coreKtx)
        add(lifecycleRunTimeKtx)
    }

    val composeLibraries = arrayListOf<String>().apply {
        add(activityCompose)
        add(composeUi)
        add(composeUiGraphics)
        add(composeUiToolingPreview)
        add(composeMaterial3)
    }

    val coroutineLibraries = arrayListOf<String>().apply {
        add(coroutineCore)
        add(coroutineAndroid)
    }

    val networkLibraries = arrayListOf<String>().apply {
        add(retrofit)
        add(gsonConverter)
        add(okhttp)
        add(loggingInterceptor)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(extJunit)
        add(espressoCore)
        add(composeUiTestJunit4)
    }

    val analyticsTestLibraries = arrayListOf<String>().apply {
        add(extJunit)
        add(espressoCore)
    }

    val debugLibraries = arrayListOf<String>().apply {
        add(composeUiTooling)
        add(composeUiTestManifest)
    }
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}