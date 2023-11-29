package concurrent

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CountDownLatch

/**
 * Startよりも先にEndが出力されるパターン
 */
fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            delay(2000)
            println("Start")
        }

        println("End.")
    }
}