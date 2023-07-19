package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import org.ktorm.database.Database

fun Application.configureRouting() {

    val database = Database.connect(
        "jdbc:postgresql://ep-morning-morning-536913.eu-central-1.aws.neon.tech/neondb?user=RAYANaouf&password=xUYdJFX5aSm8",
        driver = "org.postgresql.Driver",
        user = "RAYANaouf",
        password = "xUYdJFX5aSm8"
    )

    routing {
        get("/") {
            var res = UserResponse("hey there , i'm ktor api , build by rayan!")
            call.respond(res)
        }
    }
}


@Serializable
data class UserResponse(val message : String)
