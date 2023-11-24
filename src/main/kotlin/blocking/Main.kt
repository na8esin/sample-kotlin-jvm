package blocking

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        println("hello")
        val message = blocker()
        println(message)
    }
}

suspend fun blocker(): String {
    delay(1000)
    return "release"
}