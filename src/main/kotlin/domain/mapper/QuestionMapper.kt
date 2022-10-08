package domain.mapper

import data.model.QuestionDTO
import domain.model.Question
import domain.model.Category
import domain.model.QuestionDifficulty
import domain.model.QuestionType
import domain.model.Answer
import util.Mapper

internal object QuestionMapper : Mapper<QuestionDTO, Question> {

    override fun map(input: QuestionDTO): Question {
        val answers = arrayListOf<Answer>().apply {
            add(Answer(input.correctAnswer, true))
            addAll(input.incorrectAnswers.map { Answer(it, false) })
        }.toList()

        return Question(
            value = input.question,
            category = Category.fromValue(input.category),
            answers = answers,
            difficulty = QuestionDifficulty.fromQuery(input.difficulty),
            type = QuestionType.fromQuery(input.type)
        )
    }
}