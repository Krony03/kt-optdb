package domain.model

data class Question(
    val value: String,
    val category: Category,
    val type: QuestionType,
    val difficulty: QuestionDifficulty,
    val answers: List<Answer>
)
