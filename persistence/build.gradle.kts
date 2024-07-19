val mongoVersion: String by extra("5.1.2")
val exposedVersion: String by extra("0.52.0")
val h2Version: String by extra("2.3.230")

dependencies {
    implementation(project(":usecases"))
    implementation("org.mongodb:mongodb-driver-core:$mongoVersion")
    implementation("org.mongodb:mongodb-driver-sync:$mongoVersion")
    implementation("org.mongodb:bson:$mongoVersion")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("com.h2database:h2:$h2Version")
}