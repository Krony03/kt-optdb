package domain.model

/**
 * These in cache categories are used to map the category name from the API to the category id.
 * And mapping them as objects to simplify further translation in consumer applications.
 *
 * @author Matheus Souza
 */
open class Category(val id: Int, val name: String) {
    object ANIMALS : Category(27, "Animals")
    object ART : Category(25, "Art")
    object CELEBRITIES : Category(26, "Celebrities")
    object ENTERTAINMENT_BOARD_GAMES : Category(16, "Entertainment: Board Games")
    object ENTERTAINMENT_BOOKS : Category(10, "Entertainment: Books")
    object ENTERTAINMENT_CARTOON_AND_ANIMATIONS : Category(32, "Entertainment: Cartoon & Animations")
    object ENTERTAINMENT_COMICS : Category(29, "Entertainment: Comics")
    object ENTERTAINMENT_FILM : Category(11, "Entertainment: Film")
    object ENTERTAINMENT_JAPANESE_ANIME_AND_MANGA : Category(31, "Entertainment: Japanese Anime & Manga")
    object ENTERTAINMENT_MUSIC : Category(12, "Entertainment: Music")
    object ENTERTAINMENT_MUSICALS_AND_THEATRES : Category(13, "Entertainment: Musicals & Theatres")
    object ENTERTAINMENT_TELEVISION : Category(14, "Entertainment: Television")
    object ENTERTAINMENT_VIDEO_GAMES : Category(15, "Entertainment: Video Games")
    object GENERAL_KNOWLEDGE : Category(9, "General Knowledge")
    object GEOGRAPHY : Category(22, "Geography")
    object HISTORY : Category(23, "History")
    object MYTHOLOGY : Category(20, "Mythology")
    object POLITICS : Category(24, "Politics")
    object SCIENCE_AND_NATURE : Category(17, "Science & Nature")
    object SCIENCE_COMPUTERS : Category(18, "Science: Computers")
    object SCIENCE_GADGETS : Category(30, "Science: Gadgets")
    object SCIENCE_MATHEMATICS : Category(19, "Science: Mathematics")
    object SPORTS : Category(21, "Sports")
    object VEHICLES : Category(28, "Vehicles")
}