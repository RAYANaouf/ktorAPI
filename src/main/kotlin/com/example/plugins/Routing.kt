package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.ktorm.database.Database

fun Application.configureRouting(database: Database) {
    routing {
        get("/") {
            call.respond(UserResponse("hey there , i'm ktor api , build by rayan!"))
            call.respondText("hey there , i'm ktor api , build by rayan!")
        }
    }
}

data class UserResponse(val message : String)
