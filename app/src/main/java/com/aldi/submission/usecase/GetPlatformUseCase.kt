package com.aldi.submission.usecase

import com.aldi.submission.base.BaseUseCase
import com.aldi.submission.data.model.PlatformModel
import com.aldi.submission.data.model.ServiceResponse
import com.aldi.submission.repository.IGamekuRepository
import com.aldi.submission.ui.common.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetPlatformUseCase(
    private val repository: IGamekuRepository
): BaseUseCase() {
    operator fun invoke(): Flow<UiState<ServiceResponse<PlatformModel>>> {
        return flow {
            try {
                val response = repository.getPlatforms(keyApp)
                emit(UiState.Success(response))
            } catch (e: Exception){
                emit(UiState.Error(e.localizedMessage ?: "Unknown Error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}