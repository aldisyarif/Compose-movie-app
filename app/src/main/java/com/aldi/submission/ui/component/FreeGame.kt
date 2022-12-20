package com.aldi.submission.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aldi.submission.data.model.GameModel
import com.aldi.submission.ui.theme.SubmissionTheme

@Composable
fun FreeGame(
    gameModels: List<GameModel>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Int?) -> Unit
) {
    Row(modifier = modifier.padding(start = 24.dp, end = 24.dp)) {
        Card(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.weight(1f).padding(end = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .clickable {
                        navigateToDetail(gameModels[0].id)
                    }
            ) {
                AsyncImage(
                    model = gameModels[0].background_image,
                    contentScale = ContentScale.Crop,
                    contentDescription = gameModels[0].name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(104.dp)
                )
            }
        }
        Column(modifier = Modifier
            .weight(1f)
            .height(105.dp)
            .padding(start = 4.dp)
        ) {
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 4.dp)
            ) {
                Box(
                    modifier = Modifier.clickable {
                        navigateToDetail(gameModels[1].id)
                    }
                ) {
                    AsyncImage(
                        model = gameModels[1].background_image,
                        contentScale = ContentScale.Crop,
                        contentDescription = gameModels[1].name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    )
                }
            }
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 4.dp)
            ) {
                Box(
                    modifier = Modifier.clickable {
                        navigateToDetail(gameModels[2].id)
                    }
                ) {
                    AsyncImage(
                        model = gameModels[2].background_image,
                        contentScale = ContentScale.Crop,
                        contentDescription = gameModels[2].name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun FreeGamePreview() {
    SubmissionTheme {
        FreeGame(gameModels = listOf()){

        }
    }
}