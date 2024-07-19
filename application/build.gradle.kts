plugins {
    application
}

dependencies {
    //implementation(project(":usecases"))
    implementation(project(":persistence"))
    //implementation(project(":api"))
}

application {
    mainClass.set("br.com.cat.ApplicationKt")
}
