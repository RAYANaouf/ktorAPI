package com.example.plugins

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.util.*
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

@OptIn(InternalAPI::class)
suspend fun getUserAccessToken(serverAuthCode: String?): GoogleTokenExchangeResponse {

    println("==================>"+serverAuthCode)
//
    val client = HttpClient(CIO)
    val response: HttpResponse = client.post("https://oauth2.googleapis.com/token"){
        body = FormDataContent(Parameters.build {
            append("code", "$serverAuthCode")
            append("client_id", "309876594725-4ksbgmr7u430etharq03l7sjfu7fquct.apps.googleusercontent.com")
            append("client_secret", "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")
            append("redirect_uri", "")
            append("grant_type", "authorization_code")
        })
        contentType(ContentType.Application.FormUrlEncoded)
    }
    client.close()

    println("/*/*/*/*/*/*/*/***************  ${response.body<String>()}")

    return response.body<GoogleTokenExchangeResponse>()
}

@Serializable
data class UserResponse(val message : String)

@Serializable
data class UserIdToken(val id_token : String)

@Serializable
data class GoogleTokenExchangeResponse(
    val access_token: String,
    val scope: String,
    val token_type: String,
    val expires_in: Long,
    val refresh_token: String
)

