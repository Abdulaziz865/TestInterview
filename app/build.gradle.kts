plugins {
    Plugins.apply {
        id(application)
        kotlin(android)
        id(hilt)
        kotlin(kapt)
    }
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.compileSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures.viewBinding = true
}

dependencies {

    //Hilt
    Dependencies.Hilt.apply {
        implementation(hilt)
        kapt(hiltCompiler)
    }

    // Retrofit
    Dependencies.Retrofit.apply {
        implementation(retrofit)
        implementation(gsonConvertor)
    }

    // Gson convertor
    implementation(Dependencies.Gson.googleGson)

    //OkHttp client
    Dependencies.OkHttpClient.apply {
        implementation(bomHttp)
        implementation(okHttp)
        implementation(httpInterceptor)
    }

    // Data
    implementation(project(":data"))
    // Domain
    implementation(project(":domain"))
    // Presentation
    implementation(project(":presentation"))
}