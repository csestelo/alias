package space.uniaoinstavel.alias.game

import org.junit.Test

import org.junit.Assert.*


class TestCard {
    @Test
    fun test_constructor() {
        val card = Card("word", Role.BLUE_AGENT)
        assertEquals(card.word, "word")
        assertEquals(card.role, Role.BLUE_AGENT)
    }
}
