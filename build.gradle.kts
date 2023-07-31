buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0")
        classpath("com.google.gms:google-services:4.3.15")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.7")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application) version Versions.android apply false
    id(Plugins.kotlinAndroid) version Versions.kotlinAndroid apply false
    id(Plugins.kotlinJvm) version Versions.kotlinAndroid apply false
}