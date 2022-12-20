package com.aldi.submission.ui.screen.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.aldi.submission.ui.common.UiState
import com.aldi.submission.ui.component.DetailItem
import com.aldi.submission.ui.theme.SubmissionTheme

@Composable
fun DetailGameScreen(
    gameId: Int,
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    detailGameViewModel: DetailGameViewModel = hiltViewModel(),
) {

    val getDetailViewModel by detailGameViewModel.uiStateDetailGame.collectAsState(initial = UiState.Loading)

    Box(
        modifier = modifier,
    ){
        getDetailViewModel.let {
            when(it){
                is UiState.Loading -> {
                    detailGameViewModel.getDetailGame(gameId.toString())
                }
                is UiState.Success -> {
                    DetailItem(gameModel = it.data)
                }
                is UiState.Error -> {}
                else -> Unit
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DetailGameScreenPreview() {
    SubmissionTheme {
        DetailGameScreen(gameId = 0, navigateBack = {

        })
    }
}