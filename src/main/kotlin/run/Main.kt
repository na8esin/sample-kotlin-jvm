package run

fun main(args: Array<String>) {

}

class Hello {
    fun run() {
        run {
            println(this)
        }
        kotlin.run { // thisが参照できない
            println(tihs)
        }
    }

    companion object {
        fun run() {
            run {
                println(this)
            }
            kotlin.run { // thisが参照できない
                println(tihs)
            }
        }
    }
}