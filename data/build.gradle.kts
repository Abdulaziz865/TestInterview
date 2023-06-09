plugins {
    Plugins.apply {
        id(androidLibrary)
        id(kotlinJetbrains)
        id(hilt)
        kotlin(kapt)
    }
}

android {
    namespace = "com.example.data"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = Config.testRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    // Hilt
    Dependencies.Hilt.apply {
        //Hilt
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

    // Domain
    implementation(project (":domain"))
}
