package com.aldi.submission.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aldi.submission.R
import com.aldi.submission.data.model.PlatformModel
import com.aldi.submission.ui.theme.SubmissionTheme

@Composable
fun PlatformItem(
    platformModel: PlatformModel,
    modifier: Modifier = Modifier
) {
    
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = colorResource(id = R.color.bg_platform),
        modifier = modifier.padding(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .padding(10.dp),
            ){
            Text(text = platformModel.name ?: "", color = Color.White)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PlatformItemPreview() {
    SubmissionTheme {
        PlatformItem(
            platformModel = PlatformModel(name = "PS4")
        )
    }
}