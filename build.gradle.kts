plugins {
    id(Plugins.application) version (Versions.application) apply false
    id(Plugins.androidLibrary) version (Versions.androidLibrary) apply false
    kotlin(Plugins.android) version (Versions.android) apply false
    id(Plugins.hilt) version (Versions.hilt) apply false
    id(Plugins.kotlinJvm) version (Versions.kotlinJvm) apply false
    id("androidx.navigation.safeargs.kotlin") version "2.5.3" apply false
}