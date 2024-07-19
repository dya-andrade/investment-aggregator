plugins {
    kotlin("jvm") version "2.0.0" apply false
    id("io.ktor.plugin") version "2.3.12"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0" apply false
}

group = "br.com.cat"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

val kotlinVersion: String by extra("2.3.12")
val logbackVersion: String by extra("1.5.6")

allprojects {
    repositories {
        mavenCentral()
    }

    plugins.withId("org.jetbrains.kotlin.jvm") {
        plugins.apply("org.jetbrains.kotlin.plugin.serialization")
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "br.com.cat"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }

    dependencies {
        "implementation"(kotlin("stdlib"))
        "testImplementation"(kotlin("test"))

        "implementation"("io.ktor:ktor-server-core-jvm:$kotlinVersion")
        "implementation"("io.ktor:ktor-serialization-kotlinx-json-jvm:$kotlinVersion")
        "implementation"("io.ktor:ktor-server-content-negotiation-jvm:$kotlinVersion")
        "implementation"("io.ktor:ktor-server-netty-jvm:$kotlinVersion")
        "implementation"("ch.qos.logback:logback-classic:$logbackVersion")
        "testImplementation"("io.ktor:ktor-server-tests-jvm:$kotlinVersion")
        "testImplementation"("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}