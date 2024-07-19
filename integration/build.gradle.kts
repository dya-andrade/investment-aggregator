val ktorClientVersion: String by extra("2.3.12")

dependencies {
    implementation(project(":usecases"))
    implementation("io.ktor:ktor-client-core:$ktorClientVersion")
    implementation("io.ktor:ktor-client-cio:$ktorClientVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorClientVersion")
}