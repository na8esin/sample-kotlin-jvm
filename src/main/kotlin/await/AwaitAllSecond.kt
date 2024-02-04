package await

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * awaitAllはちょっとだけ遅い
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

    val time2 = measureTimeMillis {
        runBlocking {
            coroutineScope {
                val defer = async { sampleHeavy() }
                val defer2 = async { sampleLight() }
//                defer.await()
//                defer2.await()
            }
        }
    }
    println(time2)

    val time3 = measureTimeMillis {
        runBlocking {
            coroutineScope {
                val deferreds = listOf(
                    async { sampleHeavy() },
                    async { sampleLight() }
                )
                //deferreds.awaitAll()
            }
        }
    }
    println(time3)
}
