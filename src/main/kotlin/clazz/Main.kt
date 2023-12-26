package clazz

open class Open {
    // openは初期値が必要
    open val aaa: String = ""
}

abstract class Abstraction {
    // 初期値がなくてもOK。当たり前か。
    abstract val bbb: String
}