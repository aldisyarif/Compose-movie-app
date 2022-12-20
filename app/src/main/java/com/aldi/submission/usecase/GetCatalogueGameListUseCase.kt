package com.aldi.submission.usecase

import com.aldi.submission.base.BaseUseCase
import com.aldi.submission.data.model.GameModel
import com.aldi.submission.data.model.ServiceResponse
import com.aldi.submission.repository.IGamekuRepository
import com.aldi.submission.ui.common.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCatalogueGameListUseCase(
    private val repository: IGamekuRepository
): BaseUseCase() {
    operator fun invoke(query: String): Flow<UiState<ServiceResponse<GameModel>>> {
        return flow {
            try {
                val response = repository.getCatalogueGameList(query, keyApp)
                emit(UiState.Success(response))
            } catch (e: Exception) {
                emit(UiState.Error(e.localizedMessage ?: "Unknown Error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}