package data.model

import com.google.gson.annotations.SerializedName

internal data class CategoriesResponse(
    @SerializedName("trivia_categories")
    val result: List<CategoryDTO>
)
