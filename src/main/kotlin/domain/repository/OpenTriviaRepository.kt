package domain.repository

import data.service.OpenTriviaAPI
import domain.mapper.QuestionMapper
import domain.model.Category
import domain.model.Question
import domain.model.QuestionDifficulty
import domain.model.QuestionType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class OpenTriviaRepository(
    private val openTriviaAPI: OpenTriviaAPI,
) {

    fun getQuestions(
        amount: Int?,
        categoryId: Int?,
        difficulty: QuestionDifficulty?,
        type: QuestionType?
    ): Flow<List<Question>> = flow {
        openTriviaAPI.getQuestions(
            amount = if (amount == null || amount < 1) 1 else amount,
            category = categoryId,
            difficulty = difficulty?.name,
            type = type?.name
        ).let { res -> res.results.map { dto -> QuestionMapper.map(dto) } }.also { emit(it) }
    }

    fun getCategories(): List<Category> = Category.values().toList()

    fun getQuestionTypes(): List<QuestionType> = QuestionType.values().toList()

    fun getQuestionDifficulties(): List<QuestionDifficulty> = QuestionDifficulty.values().toList()
}