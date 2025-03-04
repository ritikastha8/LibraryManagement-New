// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.kotlin.android) apply false
//    alias(libs.plugins.google.gms.google.services) apply false
//}

// build.gradle.kts (Project-level)
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false version "1.9.24"
    alias(libs.plugins.google.gms.google.services) apply false
}