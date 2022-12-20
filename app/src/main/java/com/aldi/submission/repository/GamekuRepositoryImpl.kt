package com.aldi.submission.repository

import com.aldi.submission.data.model.GameModel
import com.aldi.submission.data.model.PlatformModel
import com.aldi.submission.data.model.ServiceResponse
import com.aldi.submission.data.remote.ApiService

class GamekuRepositoryImpl(
    private val service: ApiService
) : IGamekuRepository {

    override suspend fun getAllGames(key: String?): ServiceResponse<GameModel> =
        service.getAllGames(key)

    override suspend fun getPlatforms(key: String?): ServiceResponse<PlatformModel> =
        service.getPlatforms(key)

    override suspend fun getAllGamesByOrdering(
        field: String?,
        key: String?
    ): ServiceResponse<GameModel> =
        service.getAllGamesByOrdering(field, key)

    override suspend fun getCatalogueGameList(
        search: String?,
        key: String?
    ): ServiceResponse<GameModel> =
        service.getCatalogueGames(search, key)

    override suspend fun getDetailGame(gameId: String?, key: String?): GameModel =
        service.getDetailGames(gameId, key)
}