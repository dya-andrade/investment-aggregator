package br.com.cat

import br.com.cat.plugins.configureDatabases
import br.com.cat.plugins.configureRouting
import br.com.cat.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

/*fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}*/
fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        module()
    }.start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureRouting()
}
