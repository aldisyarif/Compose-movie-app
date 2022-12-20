package com.aldi.submission.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.aldi.submission.data.model.GameModel
import com.aldi.submission.ui.theme.SubmissionTheme
import com.aldi.submission.ui.theme.font_proxima

@Composable
fun GameItem(
    gameModel: GameModel,
    modifier: Modifier = Modifier,
    navigateToDetail: (Int?) -> Unit
) {
    Column(
        modifier = modifier
            .padding(bottom = 15.dp),
    ) {

        Row(
            modifier = Modifier
                .clickable {
                    navigateToDetail(gameModel.id)
                }
                .padding(bottom = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .weight(1f)
            ) {
                AsyncImage(
                    model = gameModel.background_image,
                    contentScale = ContentScale.Crop,
                    contentDescription = gameModel.name,
                    modifier = Modifier
                        .height(35.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(start = 10.dp)
                ,
            ) {
                Text(
                    text = gameModel.name ?: "",
                    fontSize = 14.sp,
                    fontFamily = font_proxima,
                )
                Text(
                    text = gameModel.released ?: "",
                    fontSize = 10.sp,
                    fontFamily = font_proxima,
                )
            }

            Text(
                text = gameModel.rating.toString(),
                fontSize = 10.sp,
                fontFamily = font_proxima,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                modifier = modifier.weight(1f)
            )


        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color.Gray)
        )
    }

}

@Preview
@Composable
fun NewGameItemPreview() {
    SubmissionTheme {
        GameItem(
            gameModel = GameModel(
                background_image = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
                name = "Grand Theft Auto V",
                released = "2019",
                rating = 0.0
            )
        ){

        }
    }
}