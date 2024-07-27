package com.abc.kitsu.presentation.anime.list.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.abc.kitsu.domain.kitsu.model.Anime

@Composable
fun AnimeCard(
    modifier: Modifier = Modifier,
    anime: Anime
) {
    Card(modifier = modifier) {
        Row(modifier = Modifier.padding(10.dp)) {
            AsyncImage(
                model = anime.image,
                contentDescription = "Anime Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    ),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFC4C7EB),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Star, contentDescription = "Rating Icon",
                        tint = Color.Yellow
                    )
                    Text(text = anime.rating, color = Color.Black)
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = anime.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = anime.desc,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@Preview
@Composable
fun AnimeCardPreview() {
    AnimeCard(
        modifier = Modifier,
        anime = Anime(
            id = "1",
            title = "Anime Title",
            image = "https://example.com/image.jpg",
            rating = "55",
            desc = "This is the description of the anime and this is the second line of the anime data and this is a long desc to test it"
        )
    )
}