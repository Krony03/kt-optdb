package domain.model

enum class QuestionDifficulty(val query: String) {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    UNKNOWN("unknown");

    companion object {
        fun fromQuery(query: String): QuestionDifficulty {
            return values().find { it.query == query } ?: UNKNOWN
        }
    }
}