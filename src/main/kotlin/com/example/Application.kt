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
            url = "jdbc:mysql://aws.connect.psdb.cloud/tryingv1",
            driver = "com.mysql.jdbc.Driver",
            user = "07dk6aba8gvplpby8fhq",
            password = "pscale_pw_3HZ8xYKc35a4wJCEgLindUiYvZMQTyz5CieSMeizoH"
        )

        routing {
            get("/") {
                call.respondText("hey there , i'm ktor api , build by rayan!")
            }
        }
    }
        .start(wait = true)
}

