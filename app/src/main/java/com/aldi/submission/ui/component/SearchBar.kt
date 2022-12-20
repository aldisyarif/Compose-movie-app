package com.aldi.submission.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aldi.submission.ui.theme.SubmissionTheme

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
       TextField(
           value = query,
           onValueChange = onQueryChange,
           leadingIcon = {
               Icon(
                   imageVector = Icons.Default.Search,
                   contentDescription = null
               )
           },
           colors = TextFieldDefaults.textFieldColors(
               backgroundColor = MaterialTheme.colors.surface,
               disabledIndicatorColor = Color.Transparent,
               focusedIndicatorColor = Color.Transparent,
               unfocusedIndicatorColor = Color.Transparent
           ),
           placeholder = {
               Text(text = "Cari Game")
           },
           modifier = modifier
               .padding(16.dp)
               .fillMaxWidth()
               .heightIn(min = 48.dp)
               .clip(RoundedCornerShape(16.dp))
       )
    }
}