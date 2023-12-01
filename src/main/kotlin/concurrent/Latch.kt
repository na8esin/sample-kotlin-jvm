package concurrent

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CountDownLatch

/**
 * latch.await()することで、期待通りの順番で出力させる
 */
fun main() {
    val latch = CountDownLatch(1)
    runBlocking {
         // Dispatchers.Defaultじゃないと
         // latch.await()がいつまでも終わらない
        launch(Dispatchers.Default) {
            delay(2000)
            println("Start")
            latch.countDown()
        }

        println("await...")
        latch.await()
        println("End.")
    }
}