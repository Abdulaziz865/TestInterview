plugins {
    Plugins.apply {
        id(javaLibrary)
        id(kotlinJvm)
    }
}

dependencies{

    // Coroutines
    Dependencies.Coroutines.apply {
        //Coroutines
        implementation(coroutines)
    }

    // Inject
    Dependencies.Inject.apply {
        //Inject
        implementation(inject)
    }
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}