package com.aldi.submission.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun HotListShimmer(modifier: Modifier = Modifier) {
    Column {
        Spacer(
            modifier = Modifier
                .padding(start = 24.dp, top = 20.dp, end = 24.dp)
                .height(30.dp)
                .width(90.dp)
                .background(color = Color.Gray)
                .shimmer()
        )

        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = modifier
                    .padding(start = 8.dp)
                    .padding(5.dp)
                    .width(140.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(180.dp)
                        .shimmer()
                        .background(color = Color.Gray)
                )
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = modifier
                    .padding(5.dp)
                    .width(140.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(180.dp)
                        .shimmer()
                        .background(color = Color.Gray)
                )
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = modifier
                    .padding(end = 19.dp)
                    .padding(5.dp)
                    .width(140.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(180.dp)
                        .shimmer()
                        .background(color = Color.Gray)
                )
            }
        }
    }


}

@Composable
fun PlatformListShimmer(
    modifier: Modifier = Modifier
) {
    Column {

        Spacer(
            modifier = Modifier
                .padding(start = 24.dp, top = 20.dp, end = 30.dp)
                .height(30.dp)
                .width(90.dp)
                .background(color = Color.Gray)
                .shimmer()
        )

        Row(
            modifier = modifier
                .padding(start = 10.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = modifier
                    .padding(start = 8.dp)
                    .padding(5.dp)
                    .width(90.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                        .shimmer()
                        .background(color = Color.Gray)
                )
            }

            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = modifier
                    .padding(start = 8.dp)
                    .padding(5.dp)
                    .width(90.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                        .shimmer()
                        .background(color = Color.Gray)
                )
            }

            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = modifier
                    .padding(start = 8.dp)
                    .padding(5.dp)
                    .width(90.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                        .shimmer()
                        .background(color = Color.Gray)
                )
            }

            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = modifier
                    .padding(start = 8.dp)
                    .padding(5.dp)
                    .width(90.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                        .shimmer()
                        .background(color = Color.Gray)
                )
            }

            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = modifier
                    .padding(start = 8.dp)
                    .padding(5.dp)
                    .width(90.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                        .shimmer()
                        .background(color = Color.Gray)
                )
            }

        }
    }
}

@Composable
fun FreeGameShimmer(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Spacer(
            modifier = Modifier
                .padding(start = 24.dp, top = 20.dp, end = 24.dp)
                .height(30.dp)
                .width(90.dp)
                .background(color = Color.Gray)
                .shimmer()
        )

        Row(modifier = modifier.padding(start = 24.dp, end = 24.dp)) {
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.weight(1f).padding(end = 4.dp)
            ) {
                Box(modifier = Modifier.clickable {  }) {
                    Spacer(
                        modifier = Modifier
                            .height(104.dp)
                            .shimmer()
                            .background(color = Color.Gray)
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
                    Box(modifier = Modifier.clickable {  }) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .shimmer()
                                .background(color = Color.Gray)
                        )
                    }
                }
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 4.dp)
                ) {
                    Box(modifier = Modifier.clickable {  }) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .shimmer()
                                .background(color = Color.Gray)
                        )
                    }
                }
            }
        }
    }
}