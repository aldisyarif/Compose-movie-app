package com.aldi.submission.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aldi.submission.ui.theme.font_proxima

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable (String) -> Unit
) {
    Column(modifier = modifier) {
        content(title)
    }
}

