package com.aldi.submission.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aldi.submission.R
import com.aldi.submission.ui.common.UiState
import com.aldi.submission.ui.component.*
import com.aldi.submission.ui.theme.SubmissionTheme
import com.aldi.submission.ui.theme.font_proxima

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (Int?) -> Unit
) {
    val gamesHotList by homeViewModel.uiStateGames.collectAsState(initial = UiState.Loading)
    val platformsList by homeViewModel.uiStatePlatforms.collectAsState(initial = UiState.Loading)
    val gamesFreeList by homeViewModel.uiStateFreeGame.collectAsState(initial = UiState.Loading)
    val gamesByOrdering by homeViewModel.uiStateGamesByOrdering.collectAsState(initial = UiState.Loading)

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = modifier
    ) {

        item {
            Box(
                modifier = modifier.fillMaxSize(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background_mobile),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                )

                HomeSection(title = "Hot List") { title ->
                    gamesHotList.let {
                        when(it){
                            is UiState.Loading -> {
                                homeViewModel.getAllGames()
                                HotListShimmer(modifier = modifier.padding(top = 10.dp))
                            }
                            is UiState.Success -> {
                                TextTitle(title = title)
                                if (it.data.results.isNotEmpty()){
                                    LazyRow(
                                        modifier = modifier.padding(top = 10.dp),
                                        contentPadding = PaddingValues(horizontal = 19.dp)
                                    ) {
                                        items(items = it.data.results){ data ->
                                            HotItem(
                                                gameModel = data,
                                                navigateToDetail = navigateToDetail
                                            )
                                        }
                                    }
                                }
                            }
                            is UiState.Error -> {
                                Text(text = it.errorMessage)
                            }
                            else -> Unit
                        }
                    }
                }
            }
        }

        item {
            HomeSection(title = "Your Platform") { title ->
                platformsList.let {
                    when(it){
                        is UiState.Loading -> {
                            PlatformListShimmer()
                            homeViewModel.getPlatforms()
                        }
                        is UiState.Success -> {
                            TextTitle(title = title)
                            if (it.data.results.isNotEmpty()){
                                LazyRow(
                                    modifier = modifier.padding(top = 10.dp),
                                    contentPadding = PaddingValues(horizontal = 19.dp)
                                ){
                                    items(items = it.data.results){ data ->
                                        PlatformItem(platformModel = data)
                                    }
                                }
                            }
                        }
                        is UiState.Error -> {}
                        else -> Unit
                    }
                }
            }
        }

        item {
            HomeSection(title = "Free for PS+") { title ->
                gamesFreeList.let {
                    when(it){
                        is UiState.Loading -> {
                            FreeGameShimmer()
                            homeViewModel.getFreeGame()
                        }
                        is UiState.Success -> {
                            TextTitle(title = title)
                            FreeGame(
                                gameModels = it.data,
                                modifier = modifier.padding(top = 10.dp),
                                navigateToDetail = navigateToDetail
                            )
                        }
                        is UiState.Error -> {}
                        else -> Unit
                    }
                }
            }
        }

        gamesByOrdering.let {
            when(it){
                is UiState.Loading -> {
                    homeViewModel.getAllGamesByByOrdering()
                }
                is UiState.Success -> {

                    item {
                        Text(
                            text = "New",
                            fontFamily = font_proxima,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 24.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp, top = 30.dp, end = 24.dp)
                        )
                    }

                    items(items = it.data.results){ data ->
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
fun HomeScreenPreview() {
    SubmissionTheme {
        HomeScreen(){

        }
    }
}