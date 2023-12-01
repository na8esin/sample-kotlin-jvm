package blocking

import kotlinx.coroutines.*

/**
 * android開発中に起きた、asyncをawaitしないで放置しておくと、
 * coroutineがいつまでも終わらない現象を再現したかったができない
 */
fun main() {
    runBlocking {
        coroutineScope {
            val defer = async { sample() }
            val defer2 = async { sample() }
            defer.await()
            println("Hello")
        }
    }
    println("World.")
}

suspend fun sample() {
    delay(2000)
}