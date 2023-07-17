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
//        var database = Database.connect(url = "jdbc:mysql://aws.connect.psdb.cloud/tryingv1?sslMode=VERIFY_IDENTITY", user = "3jecm085g6dhpwvc9wv7" , password = "pscale_pw_xvmkSHGJax6tGvRt3zhBzpeFg36L8QBjiIpcwBiTaXe")

        routing {
            get("/") {
                call.respondText("hey there , i'm ktor api , build by rayan!")
            }
        }
    }
        .start(wait = true)
}

