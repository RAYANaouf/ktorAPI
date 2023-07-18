package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0"){

        Database.connect(
            url = "jdbc:mysql://aws.connect.psdb.cloud/test2",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "lw02s6trz0hbjslaq01p",
            password = "pscale_pw_vpcfeDI7K1s8vzjFP6v8zCJLRAXcPCB0b0qJqOEDLMr"
        )

        routing {
            get("/") {
                call.respondText("hey there , i'm ktor api , build by rayan!")
            }
        }
    }
        .start(wait = true)
}

