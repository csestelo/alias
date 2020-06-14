package space.uniaoinstavel.alias.game;

enum class Role {
    RED_AGENT, BLUE_AGENT, BYSTANDER, ASSASSIN
}

class Card(val word: String, val role: Role) {
}
