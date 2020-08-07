@file:JvmName("ExampleJvmServer")
package uk.co.davehadley.examplekotlinserverclient.jvmserver

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import uk.co.davehadley.examplekotlinserverclient.common.ExampleData

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8000) {
        install(CORS) {
            method(HttpMethod.Options)
            method(HttpMethod.Get)
            method(HttpMethod.Post)
            method(HttpMethod.Put)
            method(HttpMethod.Delete)
            method(HttpMethod.Patch)
            header(HttpHeaders.Authorization)
            allowCredentials = true
            anyHost()
        }
        routing {
            get("/") {
                call.respondText("ExampleJvmServer", ContentType.Text.Plain)
            }
            get("/exampledata") {
                val data = ExampleData("Hello ExampleJvmServer")
                val response = Json(JsonConfiguration.Stable).stringify(ExampleData.serializer(), data)
                call.respondText(response, ContentType.Application.Json)
            }
        }
    }
    server.start(wait = true)
}