package domain.repository

import data.service.OpenTriviaAPI
import domain.mapper.QuestionMapper
import domain.model.Category
import domain.model.Question
import domain.model.QuestionDifficulty
import domain.model.QuestionType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import util.cacheCategories

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

    fun getCategories(): Flow<List<Category>> = flow {
        openTriviaAPI.getCategories().let { res ->
            res.result.map { dto -> cacheCategories.find { cache -> cache.name == dto.name } ?: Category(-1, dto.name) }
        }.also { emit(it) }
    }

    fun getQuestionTypes(): List<QuestionType> = QuestionType.values().toList()

    fun getQuestionDifficulties(): List<QuestionDifficulty> = QuestionDifficulty.values().toList()
}