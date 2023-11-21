package mockk

import io.mockk.every
import io.mockk.spyk
import kotlin.test.Test
import kotlin.test.assertEquals

class Adder {
    fun magnify(a: Int) = a
    fun add(a: Int, b: Int) = a + magnify(b)
}

class Calculator {
    fun calc() = Adder().add(1, 3)
}

class Main{
    @Test
    fun main() {
        val spy = spyk(Adder())

        every { spy.magnify(any()) } answers { firstArg<Int>() * 2 }

        assertEquals(14, spy.add(4, 5))

        // こっちは変化しない
        assertEquals(4, Calculator().calc())

        // こういう場合は、メソッドの挙動を変えてもいい
        val calc = spyk(Calculator())
        every { calc.calc() } answers { 7 }
        assertEquals(7, calc.calc())
    }
}

