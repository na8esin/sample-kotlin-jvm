package await

import kotlinx.coroutines.delay

suspend fun sampleHeavy() {
    for (i in 1..3) {
        delay(1000)
    }
}

suspend fun sampleLight() {
    delay(1000)
}