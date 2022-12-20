package com.aldi.submission.ui.screen.catalogue

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aldi.submission.R
import com.aldi.submission.ui.common.UiState
import com.aldi.submission.ui.component.GameItem
import com.aldi.submission.ui.component.SearchBar
import com.aldi.submission.ui.theme.SubmissionTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CatalogueScreen(
    modifier: Modifier = Modifier,
    catalogueViewModel: CatalogueViewModel = hiltViewModel(),
    navigateToDetail: (Int?) -> Unit
) {

    val catalogueGameList by catalogueViewModel.uiStateCatalogueGame.collectAsState(initial = UiState.Loading)
    val query by catalogueViewModel.query

    val listState = rememberLazyListState()


    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        stickyHeader {
            Box(
                modifier = modifier.fillMaxSize(),
            ) {
                SearchBar(
                    query = query,
                    onQueryChange = catalogueViewModel::searchCatalogueGame,
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .background(colorResource(id = R.color.background))
                )
            }
        }

        catalogueGameList.let {
            when(it){
                is UiState.Loading -> {
                    catalogueViewModel.searchCatalogueGame("")
                }
                is UiState.Success -> {
                    items(items = it.data.results) { data ->
                        GameItem(
                            gameModel = data,
                            modifier = Modifier
                                .padding(start = 24.dp, end = 24.dp),
                            navigateToDetail = navigateToDetail
                        )
                    }
                }
                is UiState.Error -> {}
                else -> Unit
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview() {
    SubmissionTheme {
        CatalogueScreen(navigateToDetail = {

        })
    }
}