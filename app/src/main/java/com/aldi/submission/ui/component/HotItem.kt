package com.aldi.submission.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aldi.submission.data.model.GameModel
import com.aldi.submission.ui.theme.SubmissionTheme

@Composable
fun HotItem(
    gameModel: GameModel,
    modifier: Modifier = Modifier,
    navigateToDetail: (Int?) -> Unit
) {

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(5.dp)
            .width(162.dp)
    ) {
        Box(modifier = modifier
            .clickable {
                navigateToDetail(gameModel.id)
            }
        ) {
            AsyncImage(
                model = gameModel.background_image,
                contentScale = ContentScale.Crop,
                contentDescription = gameModel.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HotItemPreview() {
    SubmissionTheme {
        HotItem(
            gameModel = GameModel(
                background_image = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
                name = "Grand Theft Auto V"
            )
        ){

        }
    }
}