package com.aldi.submission.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aldi.submission.data.model.GameModel
import com.aldi.submission.data.model.ParentPlatformsItem

@Composable
fun DetailItem(
    gameModel: GameModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
    ) {
        AsyncImage(
            model = gameModel.background_image,
            contentScale = ContentScale.Crop,
            contentDescription = gameModel.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        TextTitle(title = gameModel.name ?: "")
        
        Text(
            text = getPlatformToString(gameModel.parent_platforms),
            modifier = Modifier.padding(start = 24.dp, end = 24.dp)
        )

        TextTitle(title = "Requirements")



        Text(
            text = gameModel.platforms?.get(0)?.requirements?.minimum ?: "",
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
        )


        Text(
            text = gameModel.platforms?.get(0)?.requirements?.recommended ?: "",
            modifier = Modifier.padding(start = 24.dp, end = 24.dp)
        )
    }
}

private fun getPlatformToString(platforms: List<ParentPlatformsItem?>?): String {
    val builder = StringBuilder()
    platforms?.forEach { data ->
        builder.append(data?.platform?.name).append(" . ")
    }
    return builder.toString()
}
