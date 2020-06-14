package space.uniaoinstavel.alias.game

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestCard {
    @Test
    fun test_constructor() {
        val card = Card("word", Role.BLUE_AGENT)
        assertEquals(card.word, "word")
        assertEquals(card.role, Role.BLUE_AGENT)
    }
}
