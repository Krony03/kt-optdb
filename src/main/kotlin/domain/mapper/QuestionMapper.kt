package domain.mapper

import data.model.QuestionDTO
import domain.model.Category
import domain.model.Question
import domain.model.Answer
import domain.model.QuestionDifficulty
import domain.model.QuestionType
import util.Mapper
import util.cacheCategories

internal object QuestionMapper : Mapper<QuestionDTO, Question> {

    override fun map(input: QuestionDTO): Question {
        val answers = arrayListOf<Answer>().apply {
            add(Answer(input.correctAnswer, true))
            addAll(input.incorrectAnswers.map { Answer(it, false) })
        }.toList()

        val category = cacheCategories.find { it.name == input.category } ?: Category(-1, input.category)

        return Question(
            value = input.question,
            category = category,
            answers = answers,
            difficulty = QuestionDifficulty.fromQuery(input.difficulty),
            type = QuestionType.fromQuery(input.type)
        )
    }
}