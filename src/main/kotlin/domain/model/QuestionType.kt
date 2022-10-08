package domain.model

enum class QuestionType(val query: String) {
    MULTIPLE_CHOICE("multiple"),
    TRUE_OR_FALSE("boolean"),
    UNKNOWN("unknown");

    companion object {
        fun fromQuery(query: String): QuestionType {
            return values().find { it.query == query } ?: UNKNOWN
        }
    }
}