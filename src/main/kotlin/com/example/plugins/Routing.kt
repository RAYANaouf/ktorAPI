package com.example.plugins

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.ktorm.database.Database
import kotlinx.serialization.Serializable

fun Application.configureRouting() {

    val database = Database.connect(
        "jdbc:postgresql://ep-morning-morning-536913.eu-central-1.aws.neon.tech/neondb?user=RAYANaouf&password=xUYdJFX5aSm8",
        driver = "org.postgresql.Driver",
        user = "RAYANaouf",
        password = "xUYdJFX5aSm8"
    )

    routing {
        get("/") {
            var token = call.request.headers["Authorization"]
            var res = UserResponse("hey there , i'm ktor api , build by rayan!\n your token : $token")
            call.respond(res)
            call.respondText("idToken")
        }

        post("/token-exchange") {
            var token = call.request.headers["Authorization"]

            var accessToken = getUserAccessToken(token)

            var responsee = UserResponse("$accessToken")

            call.respond(responsee)
        }

    }
}

suspend fun getUserAccessToken(idToken: String?): String {

    val client = HttpClient(CIO)
    val response: HttpResponse = client.get("https://ktor.io/")
    println("oooooooooooooooooooooooooo"+response.status)
    client.close()
    return response.body<String>()
}

data class AccessTokenResponse(val access_token: String)








@Serializable
data class UserResponse(val message : String)

@Serializable
data class UserIdToken(val id_token : String)
