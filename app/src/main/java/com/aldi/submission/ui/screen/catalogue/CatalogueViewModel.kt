package com.aldi.submission.ui.screen.catalogue

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldi.submission.data.model.GameModel
import com.aldi.submission.data.model.ServiceResponse
import com.aldi.submission.ui.common.UiState
import com.aldi.submission.usecase.GetCatalogueGameListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogueViewModel @Inject constructor(
    private val getCatalogueGameListUseCase: GetCatalogueGameListUseCase
): ViewModel() {

    private val _uiStateCatalogueGame: MutableStateFlow<UiState<ServiceResponse<GameModel>>?> = MutableStateFlow(UiState.Loading)
    val uiStateCatalogueGame get() = _uiStateCatalogueGame

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun searchCatalogueGame(newQuery: String){
        _query.value = newQuery
        viewModelScope.launch {
            getCatalogueGameListUseCase(_query.value).collect {
                _uiStateCatalogueGame.emit(it)
            }
        }

    }
}