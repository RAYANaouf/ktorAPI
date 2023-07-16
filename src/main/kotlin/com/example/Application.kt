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
        var database = Database.connect(url = "jdbc:mysql://aws.connect.psdb.cloud/tryingv1?sslMode=VERIFY_IDENTITY", user = "4cwyv9d4g129lxzx3rfp" , password = "pscale_pw_vSsSd9Ma6xfS3Z1oGBsk77rMjWqaB9bMODzgT1D50JM")

        routing {
            get("/") {
                call.respondText("hey there , i'm ktor api , build by rayan!")
            }
        }
    }
        .start(wait = true)
}

