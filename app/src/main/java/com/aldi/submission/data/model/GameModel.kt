package com.aldi.submission.data.model

data class GameModel(
    val added: Int? = null,
    val rating: Double? = null,
    val metacritic: Int? = null,
    val playtime: Int? = null,
    val shortScreenshots: List<ShortScreenshotsItem?>? = null,
    val platforms: List<PlatformsItem?>? = null,
    val userGame: Any? = null,
    val ratingTop: Int? = null,
    val reviewsTextCount: Int? = null,
    val ratings: List<RatingsItem?>? = null,
    val genres: List<GenresItem?>? = null,
    val saturatedColor: String? = null,
    val id: Int? = null,
    val addedByStatus: AddedByStatus? = null,
    val parent_platforms: List<ParentPlatformsItem?>? = null,
    val ratingsCount: Int? = null,
    val slug: String? = null,
    val released: String? = null,
    val suggestionsCount: Int? = null,
    val stores: List<StoresItem?>? = null,
    val tags: List<TagsItem?>? = null,
    val background_image: String? = null,
    val tba: Boolean? = null,
    val dominantColor: String? = null,
    val esrbRating: EsrbRating? = null,
    val name: String? = null,
    val updated: String? = null,
    val clip: Any? = null,
    val reviewsCount: Int? = null
)

data class RatingsItem(
    val count: Int?,
    val id: Int?,
    val title: String?,
    val percent: Double?
)

data class EsrbRating(
    val name: String?,
    val id: Int?,
    val slug: String?
)

data class ParentPlatformsItem(
    val platform: Platform?
)

data class Store(
    val gamesCount: Int?,
    val domain: String?,
    val name: String?,
    val id: Int?,
    val imageBackground: String?,
    val slug: String?
)

data class RequirementsEn(
    val minimum: String?,
    val recommended: String?
)

data class ShortScreenshotsItem(
    val image: String?,
    val id: Int?
)

data class StoresItem(
    val id: Int?,
    val store: Store?
)

data class TagsItem(
    val gamesCount: Int?,
    val name: String?,
    val language: String?,
    val id: Int?,
    val imageBackground: String?,
    val slug: String?
)

data class Platform(
    val image: Any?,
    val gamesCount: Int?,
    val yearEnd: Any?,
    val yearStart: Any?,
    val name: String?,
    val id: Int?,
    val imageBackground: String?,
    val slug: String?
)

data class AddedByStatus(
    val owned: Int?,
    val beaten: Int?,
    val dropped: Int?,
    val yet: Int?,
    val playing: Int?,
    val toplay: Int?
)

data class GenresItem(
    val gamesCount: Int?,
    val name: String?,
    val id: Int?,
    val imageBackground: String?,
    val slug: String?
)

data class PlatformsItem(
    val requirementsRu: Any?,
    val requirements_en: RequirementsEn?,
    val releasedAt: String?,
    val platform: Platform?,
    val requirements: RequirementsEn?
)

