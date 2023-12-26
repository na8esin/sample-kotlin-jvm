package collections

fun main() {
    val codecs = listOf("video/a", "video/c", "audio/b", "audio/b")

    val folded = codecs.fold<String,  MutableList<String>>(
        mutableListOf()
    ) { acc, e ->
        if (e.startsWith("video")) {
            acc.add(e)
        }
        acc
    }

    println(folded)
}