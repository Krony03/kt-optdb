package data.model

import com.google.gson.annotations.SerializedName

internal data class QuestionsResponse(
    @SerializedName("response_code")
    val responseCode: Int,
    val results: List<QuestionDTO>
)
