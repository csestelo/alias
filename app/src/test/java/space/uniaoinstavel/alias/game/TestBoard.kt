package space.uniaoinstavel.alias.game

import org.junit.Test

import org.junit.Assert.*


class TestBoard {
    @Test
    fun test_constructor_ok() {
        val cards = listOf(
            Card("w1", Role.RED_AGENT),
            Card("w2", Role.BLUE_AGENT),
            Card("w3", Role.ASSASSIN)
        )

        val board = Board(cards)
        assertEquals(board.cards, cards)
    }

    @Test(expected = MissingAssassinException::class)
    fun test_constructor_missing_assassin() {
        val cards = listOf(
            Card("w1", Role.RED_AGENT),
            Card("w2", Role.BLUE_AGENT)
        )

        Board(cards)
    }

    @Test(expected = TooManyAssassinsException::class)
    fun test_constructor_too_many_assassins() {
        val cards = listOf(
            Card("w1", Role.RED_AGENT),
            Card("w2", Role.BLUE_AGENT),
            Card("w3", Role.ASSASSIN),
            Card("w4", Role.ASSASSIN)
        )

        Board(cards)
    }

    @Test(expected = InvalidAgentDistributionException::class)
    fun test_constructor_different_numbers_of_cards_per_team() {
        val cards = listOf(
            Card("w1", Role.RED_AGENT),
            Card("w2", Role.BLUE_AGENT),
            Card("w3", Role.BLUE_AGENT),
            Card("w4", Role.ASSASSIN)
        )

        Board(cards)
    }

    @Test(expected = EmptyBoardException::class)
    fun test_constructor_empty_board() {
        Board(
            listOf(
                Card("w3", Role.ASSASSIN)
            )
        )
    }

    @Test(expected = DuplicateWordsException::class)
    fun test_constructor_duplicate_words() {
        Board(
            listOf(
                Card("w1", Role.RED_AGENT),
                Card("w1", Role.BLUE_AGENT),
                Card("w3", Role.ASSASSIN)
            )
        )
    }
}

