package com.aldi.submission.usecase

import com.aldi.submission.base.BaseUseCase
import com.aldi.submission.data.model.GameModel
import com.aldi.submission.repository.IGamekuRepository
import com.aldi.submission.ui.common.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetRandomUseCase(
    private val repository: IGamekuRepository
): BaseUseCase() {
    operator fun invoke(length: Int): Flow<UiState<List<GameModel>>> {
        return flow {
            try {
                val response = repository.getAllGames(keyApp).results.shuffled().take(length).toList()
                emit(UiState.Success(response))
            } catch (e: Exception) {
                emit(UiState.Error(e.localizedMessage ?: "Unknown Error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}