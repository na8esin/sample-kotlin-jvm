package `object`

object Tokens {
    val token: String
        get() {
            println("hello")
            return "a"
        }

    // こっちはメソッドの処理が呼ばれるのは一回だけ
    val tokenB = create()
    private fun create(): String {
        println("welcome")
        return "b"
    }
}

/**
 * 出力順番
 *
 * welcome
 * hello
 * a
 * hello
 * a
 * b
 * b
 */
fun main(args: Array<String>) {
    println(Tokens.token)
    println(Tokens.token)

    println(Tokens.tokenB)
    println(Tokens.tokenB)
}