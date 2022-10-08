import data.service.createOpenTriviaAPI
import domain.model.Category
import domain.model.Question
import domain.model.QuestionDifficulty
import domain.model.QuestionType
import domain.repository.OpenTriviaRepository
import kotlinx.coroutines.flow.Flow
import java.time.Duration

/**
 * This is the entrypoint for the OpenTrivia API consumer library for Kotlin.
 * It provides a simple interface to some request of the [OpenTrivia API](https://opentdb.com/)
 *
 *
 * @since 0.1.0-alpha
 * @author Matheus Souza
 */
class OpenTriviaClient private constructor(
    private val timeout: Duration = DEFAULT_TIMEOUT
) {

    private constructor(builder: Builder) : this(builder.timeout)

    private val repository: OpenTriviaRepository by lazy {
        OpenTriviaRepository(
            openTriviaAPI = createOpenTriviaAPI(timeout)
        )
    }

    /**
     * @param amount is an optional parameter that specifies the amount of questions to be returned.
     * The <b>default</b> value is 1.
     *
     * @param categoryId is an optional parameter that specifies the category of the questions to be returned.
     * You can get the list of available categories by calling [getCategories].
     *
     * @param difficulty is an optional parameter that specifies the difficulty of the questions to be returned.
     * You can get the list of available difficulties by calling [getQuestionDifficulties].
     *
     * @param type is an optional parameter that specifies the type of the questions to be returned.
     * You can get the list of available types by calling [getQuestionTypes].
     *
     * @return a [Flow] of [List] of [Question]s that will be emitted when the request is successful.
     */
    fun getQuestions(
        amount: Int = 1,
        categoryId: Int? = null,
        difficulty: QuestionDifficulty? = null,
        type: QuestionType? = null
    ): Flow<List<Question>> = repository.getQuestions(amount, categoryId, difficulty, type)

    fun getCategories(): Flow<List<Category>> = repository.getCategories()

    fun getQuestionTypes(): List<QuestionType> = repository.getQuestionTypes()

    fun getQuestionDifficulties(): List<QuestionDifficulty> = repository.getQuestionDifficulties()

    class Builder {
        var timeout: Duration = DEFAULT_TIMEOUT

        fun timeout(timeout: Duration) = apply { this.timeout = timeout }

        fun build() = OpenTriviaClient(timeout)
    }

    companion object {
        private val DEFAULT_TIMEOUT = Duration.ofSeconds(30)

        fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }
}