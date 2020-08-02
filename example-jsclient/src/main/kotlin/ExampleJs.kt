package uk.co.davehadley.examplekotlinserverclient.jsclient

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import react.*
import react.dom.h1
import react.dom.p
import react.dom.render
import uk.co.davehadley.examplekotlinserverclient.common.ExampleData
import kotlin.browser.document
import kotlin.browser.window

external interface ExampleJsState : RState {
    var message: String
}

class ExampleJs : RComponent<RProps, ExampleJsState>() {

    override fun ExampleJsState.init() {
        message = ""

        MainScope().launch {
            val msg = fetchFromServer().message
            setState { message = msg }
        }
    }

    override fun RBuilder.render() {
        h1 { +"Example JS" }
        p { +"server says ${state.message}" }
    }

}

suspend fun fetchFromServer(): ExampleData {
    val responsePromise = window.fetch("http://localhost:8000/exampledata")
    val response = responsePromise.await()
    val jsonPromise = response.json()
    val json = jsonPromise.await()
    return json.unsafeCast<ExampleData>()
}

fun main() {
    render(document.getElementById("root")) {
        child(ExampleJs::class) {}
    }
}
