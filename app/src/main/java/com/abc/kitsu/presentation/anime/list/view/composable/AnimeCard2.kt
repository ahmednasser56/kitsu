package com.abc.kitsu.presentation.anime.list.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.abc.kitsu.domain.kitsu.model.Anime

@Composable
fun AnimeCard2(
    modifier: Modifier = Modifier,
    anime: Anime
) {
    Card(modifier = modifier) {
        ConstraintLayout(modifier = Modifier.padding(10.dp).fillMaxWidth()) {

            val (image, rating, title, desc) = createRefs()

            AsyncImage(
                model = anime.image,
                contentDescription = "Anime Image",
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .constrainAs(image) {
                        top.linkTo(rating.top)
                        bottom.linkTo(desc.bottom)
                        start.linkTo(parent.start)
                        width = Dimension.ratio("1:1")
                        height = Dimension.fillToConstraints
                    },
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .background(
                        color = Color(0xFFC4C7EB),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(horizontal = 6.dp, vertical = 2.dp)
                    .constrainAs(rating) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end, margin = 8.dp)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Star, contentDescription = "Rating Icon",
                    tint = Color.Yellow
                )
                Text(text = anime.rating, color = Color.Black)
            }

            Text(
                text = anime.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.constrainAs(title){
                    top.linkTo(rating.bottom, margin = 2.dp)
                    start.linkTo(rating.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            )

            Text(
                text = anime.desc,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.constrainAs(desc){
                    top.linkTo(title.bottom, margin = 2.dp)
                    start.linkTo(rating.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            )
        }
    }
}


@Preview
@Composable
fun AnimeCard2Preview() {
    AnimeCard2(
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