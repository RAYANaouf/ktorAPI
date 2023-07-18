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
            user = "uemxywdoxh38jx0hbjak",
            password = "pscale_pw_V2wAYXaEsRYLDBVRLsQsSdb8FdRC9hjx4qoH2glw0Ca"
        )

        routing {
            get("/") {
                call.respondText("hey there , i'm ktor api , build by rayan!")
            }
        }
    }
        .start(wait = true)
}

