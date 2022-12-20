package com.aldi.submission.repository

import com.aldi.submission.data.model.GameModel
import com.aldi.submission.data.model.PlatformModel
import com.aldi.submission.data.model.ServiceResponse

interface IGamekuRepository {
    suspend fun getAllGames(
        key: String?
    ) : ServiceResponse<GameModel>

    suspend fun getPlatforms(
        key: String?
    ): ServiceResponse<PlatformModel>

    suspend fun getAllGamesByOrdering(
        field: String?,
        key: String?
    ): ServiceResponse<GameModel>

    suspend fun getCatalogueGameList(
        search: String?,
        key: String?
    ): ServiceResponse<GameModel>

    suspend fun getDetailGame(
        gameId: String?,
        key: String?
    ): GameModel

}