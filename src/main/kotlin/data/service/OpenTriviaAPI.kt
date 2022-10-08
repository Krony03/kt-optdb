package data.service

import data.model.QuestionsResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.Duration

internal interface OpenTriviaAPI {

    @GET("api.php")
    suspend fun getQuestions(
        @Query("amount") amount: Int?,
        @Query("category") category: Int?,
        @Query("difficulty") difficulty: String?,
        @Query("type") type: String?
    ): QuestionsResponse
}

internal fun createOpenTriviaAPI(
    timeout: Duration
): OpenTriviaAPI {

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(timeout)
        .callTimeout(timeout)
        .readTimeout(timeout)
        .writeTimeout(timeout)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://opentdb.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(OpenTriviaAPI::class.java)
}