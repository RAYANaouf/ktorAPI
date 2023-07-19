package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 3306){




    }
        .start(wait = true)
}

fun Application.module() {
    val database = Database.connect(
        "jdbc:postgresql://ep-morning-morning-536913.eu-central-1.aws.neon.tech/neondb?user=RAYANaouf&password=xUYdJFX5aSm8",
        driver = "org.postgresql.Driver",
        user = "RAYANaouf",
        password = "xUYdJFX5aSm8"
    )
    configureRouting(database)
}


