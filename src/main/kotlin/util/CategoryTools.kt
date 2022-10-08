package util

import domain.model.Category

internal val cacheCategories: List<Category> by lazy {
    listOf(
        Category.ANIMALS,
        Category.ART,
        Category.CELEBRITIES,
        Category.ENTERTAINMENT_BOARD_GAMES,
        Category.ENTERTAINMENT_BOOKS,
        Category.ENTERTAINMENT_CARTOON_AND_ANIMATIONS,
        Category.ENTERTAINMENT_COMICS,
        Category.ENTERTAINMENT_FILM,
        Category.ENTERTAINMENT_JAPANESE_ANIME_AND_MANGA,
        Category.ENTERTAINMENT_MUSIC,
        Category.ENTERTAINMENT_MUSICALS_AND_THEATRES,
        Category.ENTERTAINMENT_TELEVISION,
        Category.ENTERTAINMENT_VIDEO_GAMES,
        Category.GENERAL_KNOWLEDGE,
        Category.GEOGRAPHY,
        Category.HISTORY,
        Category.MYTHOLOGY,
        Category.POLITICS,
        Category.SCIENCE_AND_NATURE,
        Category.SCIENCE_COMPUTERS,
        Category.SCIENCE_GADGETS,
        Category.SCIENCE_MATHEMATICS,
        Category.SPORTS,
        Category.VEHICLES
    )
}
