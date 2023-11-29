package list

/**
 * -ea JVM optionが必要
 */
fun main() {
    val list = mutableListOf("りんご", "ゴリラ", "ラッパ")
    list.add(3, "パンダ")
    assert(list == mutableListOf("りんご", "ゴリラ", "ラッパ", "パンダ"))

    val list2 = mutableListOf("りんご", "ゴリラ", "ラッパ")
    list2.add(2, "パンダ")
    assert(list2 == mutableListOf("りんご", "ゴリラ", "パンダ", "ラッパ"))
}