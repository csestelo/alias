package space.uniaoinstavel.alias.game

class MissingAssassinException : Throwable("No assassin was defined")
class TooManyAssassinsException : Throwable("More than one assassin was defined")
class InvalidAgentDistributionException : Throwable("Number of red and blue agents are different")
class EmptyBoardException : Throwable("No agents were defined")
class DuplicateWordsException : Throwable("The same word was used in more than one card")


class Board(cards: Iterable<Card>) {
    var cards: ArrayList<Card> = ArrayList()

    init {
        val words: MutableSet<String> = HashSet()
        val rolesCount = mutableMapOf<Role, Int>().withDefault { 0 }
        for (card in cards) {
            if (card.word in words) {
                throw DuplicateWordsException()
            } else {
                words.add(card.word)
            }
            rolesCount[card.role] = rolesCount.getValue(card.role) + 1
            this.cards.add(card)
        }

        if (rolesCount.getValue(Role.ASSASSIN) == 0) {
            throw MissingAssassinException()
        } else if (rolesCount.getValue(Role.ASSASSIN) > 1) {
            throw TooManyAssassinsException()
        }
        if (rolesCount.getValue(Role.BLUE_AGENT) == 0 || rolesCount.getValue(Role.RED_AGENT) == 0) {
            throw EmptyBoardException()
        } else if (rolesCount.getValue(Role.BLUE_AGENT) != rolesCount.getValue(Role.RED_AGENT)) {
            throw InvalidAgentDistributionException()
        }
    }
}
