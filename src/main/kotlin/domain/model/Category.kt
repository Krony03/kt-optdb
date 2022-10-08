package domain.model

enum class Category(val id: Int, val value: String) {
    ANIMALS(27, "Animals"),
    ART(25, "Art"),
    CELEBRITIES(26, "Celebrities"),
    ENTERTAINMENT_BOARD_GAMES(16, "Entertainment: Board Games"),
    ENTERTAINMENT_BOOKS(10, "Entertainment: Books"),
    ENTERTAINMENT_CARTOON_AND_ANIMATIONS(32, "Entertainment: Cartoon & Animations"),
    ENTERTAINMENT_COMICS(29, "Entertainment: Comics"),
    ENTERTAINMENT_FILM(11, "Entertainment: Film"),
    ENTERTAINMENT_JAPANESE_ANIME_AND_MANGA(31, "Entertainment: Japanese Anime & Manga"),
    ENTERTAINMENT_MUSIC(12, "Entertainment: Music"),
    ENTERTAINMENT_MUSICALS_AND_THEATRES(13, "Entertainment: Musicals & Theatres"),
    ENTERTAINMENT_TELEVISION(14, "Entertainment: Television"),
    ENTERTAINMENT_VIDEO_GAMES(15, "Entertainment: Video Games"),
    GENERAL_KNOWLEDGE(9, "General Knowledge"),
    GEOGRAPHY(22, "Geography"),
    HISTORY(23, "History"),
    MYTHOLOGY(20, "Mythology"),
    POLITICS(24, "Politics"),
    SCIENCE_AND_NATURE(17, "Science & Nature"),
    SCIENCE_COMPUTERS(18, "Science: Computers"),
    SCIENCE_GADGETS(30, "Science: Gadgets"),
    SCIENCE_MATHEMATICS(19, "Science: Mathematics"),
    SPORTS(21, "Sports"),
    VEHICLES(28, "Vehicles"),
    UNKNOWN(-1, "Unknown");

    companion object {
        fun fromValue(value: String): Category {
            return values().find { it.value == value } ?: UNKNOWN
        }
    }
}