package com.aldi.submission.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.aldi.submission.R
import com.aldi.submission.ui.theme.SubmissionTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(painter = painterResource(id = R.drawable.dirku), contentDescription = stringResource(R.string.aldis_long_name))
            Text(text = stringResource(R.string.aldis_long_name))
            Text(text = stringResource(R.string.aldis_email))
        }
    }
}

@Preview
@Composable
fun AboutScreenPreview() {
    SubmissionTheme {
        AboutScreen()
    }
}