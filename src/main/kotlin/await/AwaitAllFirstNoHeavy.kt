package await

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * 同じ時間かかる処理はバラバラに起動した方がはやい
 */
fun main() {
    val time = measureTimeMillis {
        runBlocking {
            coroutineScope {
                val defer = async { delayOneSecond() }
                defer.await()
                val defer2 = async { delayOneSecond() }
                defer2.await()
            }
        }
    }
    println(time)

    val time2 = measureTimeMillis {
        runBlocking {
            coroutineScope {
                val deferreds = listOf(
                    async { delayOneSecond() },
                    async { delayOneSecond() }
                )
                deferreds.awaitAll()
            }
        }
    }
    println(time2)

    val time3 = measureTimeMillis {
        runBlocking {
            coroutineScope {
                val defer = async { delayOneSecond() }
                val defer2 = async { delayOneSecond() }
                defer.await()
                defer2.await()
            }
        }
    }
    println(time3)
}

suspend fun delayOneSecond() {
    delay(1000)
}