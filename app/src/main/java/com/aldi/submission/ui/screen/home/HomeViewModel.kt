package com.aldi.submission.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldi.submission.data.model.GameModel
import com.aldi.submission.data.model.PlatformModel
import com.aldi.submission.data.model.ServiceResponse
import com.aldi.submission.ui.common.UiState
import com.aldi.submission.usecase.GetAllGameUseCase
import com.aldi.submission.usecase.GetAllGamesByOrderingUseCase
import com.aldi.submission.usecase.GetPlatformUseCase
import com.aldi.submission.usecase.GetRandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllGameUseCase: GetAllGameUseCase,
    private val getPlatformUseCase: GetPlatformUseCase,
    private val getRandomUseCase: GetRandomUseCase,
    private val getAllGamesByOrderingUseCase: GetAllGamesByOrderingUseCase
): ViewModel() {

    private val _uiStateAllGames: MutableStateFlow<UiState<ServiceResponse<GameModel>>?> = MutableStateFlow(
        UiState.Loading)
    val uiStateGames get() = _uiStateAllGames

    private val _uiStateAllPlatforms: MutableStateFlow<UiState<ServiceResponse<PlatformModel>>?> = MutableStateFlow(
        UiState.Loading)
    val uiStatePlatforms get() = _uiStateAllPlatforms

    private val _uiStateFreeGame: MutableStateFlow<UiState<List<GameModel>>?> = MutableStateFlow(
        UiState.Loading)
    val uiStateFreeGame get() = _uiStateFreeGame

    private val _uiStateAllGamesByOrdering: MutableStateFlow<UiState<ServiceResponse<GameModel>>?> = MutableStateFlow(
        UiState.Loading)
    val uiStateGamesByOrdering get() = _uiStateAllGamesByOrdering


    fun getAllGames(){
        viewModelScope.launch {
            getAllGameUseCase().collect {
                _uiStateAllGames.emit(it)
            }
        }
    }

    fun getPlatforms(){
        viewModelScope.launch {
            getPlatformUseCase().collect {
                _uiStateAllPlatforms.emit(it)
            }
        }
    }

    fun getFreeGame(){
        viewModelScope.launch {
            getRandomUseCase(3).collect {
                _uiStateFreeGame.emit(it)
            }
        }
    }

    fun getAllGamesByByOrdering(){
        viewModelScope.launch {
            getAllGamesByOrderingUseCase("-updated").collect {
                _uiStateAllGamesByOrdering.emit(it)
            }
        }
    }
}