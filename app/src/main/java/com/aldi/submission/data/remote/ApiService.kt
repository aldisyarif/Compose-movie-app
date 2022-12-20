package com.aldi.submission.data.remote

import com.aldi.submission.data.model.GameModel
import com.aldi.submission.data.model.PlatformModel
import com.aldi.submission.data.model.ServiceResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getAllGames(
        @Query("key") key: String?
    ): ServiceResponse<GameModel>

    @GET("platforms/lists/parents")
    suspend fun getPlatforms(
        @Query("key") key: String?
    ): ServiceResponse<PlatformModel>


    @GET("games")
    suspend fun getAllGamesByOrdering(
        @Query("ordering") field: String?,
        @Query("key") key: String?
    ): ServiceResponse<GameModel>

    @GET("games")
    suspend fun getCatalogueGames(
        @Query("search") query: String?,
        @Query("key") key: String?
    ): ServiceResponse<GameModel>

    @GET("games/{id}")
    suspend fun getDetailGames(
        @Path("id") gameId: String?,
        @Query("key") key: String?
    ): GameModel

}