package await

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * 実行順が原因の可能性もあるから、awaitAllを最初にしてみた
 */
fun main() {
    val time = measureTimeMillis {
        runBlocking {
            coroutineScope {
                val defer = async { sampleHeavy() }
                defer.await()
                val defer2 = async { sampleLight() }
                defer2.await()
            }
        }
    }
    println(time)

    val time3 = measureTimeMillis {
        runBlocking {
            coroutineScope {
                val deferreds = listOf(
                    async { sampleHeavy() },
                    async { sampleLight() }
                )
                deferreds.awaitAll()
            }
        }
    }
    println(time3)


    val time2 = measureTimeMillis {
        runBlocking {
            coroutineScope {
                val defer = async { sampleHeavy() }
                val defer2 = async { sampleLight() }
                defer.await()
                defer2.await()
            }
        }
    }
    println(time2)
}

