package br.com.cat

import br.com.cat.plugins.configureDatabases
import br.com.cat.plugins.configureRouting
import br.com.cat.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureRouting()
}
