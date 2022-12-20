package com.aldi.submission.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldi.submission.data.model.GameModel
import com.aldi.submission.ui.common.UiState
import com.aldi.submission.usecase.GetDetailGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailGameViewModel @Inject constructor(
    private val getDetailGameUseCase: GetDetailGameUseCase
): ViewModel() {
    private val _uiStateDetailGame: MutableStateFlow<UiState<GameModel>?> = MutableStateFlow(
        UiState.Loading)
    val uiStateDetailGame get() = _uiStateDetailGame

    fun getDetailGame(gameId: String){
        viewModelScope.launch {
            getDetailGameUseCase(gameId).collect {
                _uiStateDetailGame.emit(it)
            }
        }
    }
}