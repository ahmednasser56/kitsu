package com.abc.kitsu.presentation.anime.list.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.abc.kitsu.presentation.anime.list.event.AnimesEvent
import com.abc.kitsu.presentation.anime.list.state.AnimesState
import com.abc.kitsu.presentation.anime.list.view.composable.AnimatedLoading
import com.abc.kitsu.presentation.anime.list.view.composable.AnimeCard
import com.abc.kitsu.presentation.anime.list.view.composable.AnimeCard2
import com.abc.kitsu.presentation.anime.list.viewModel.AnimesViewModel
import com.abc.kitsu.presentation.common.extensions.collectAsEffect
import com.abc.kitsu.presentation.common.extensions.toast


@Composable
fun AnimesScreen(
    navController: NavHostController,
    viewModel: AnimesViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    //region collect flows

    viewModel.error.collectAsEffect {
        context.toast(it)
    }

    viewModel.errorStringId.collectAsEffect {
        context.toast(it)
    }
    //endregion

    AnimesContent(
        state = viewModel.state,
        onEvent = { viewModel.onEvent(context, it) }
    )
}

@Composable
private fun AnimesContent(
    state: AnimesState,
    onEvent: (AnimesEvent) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->

        Box(modifier = Modifier.
        padding(
            top = innerPadding.calculateTopPadding() + 20.dp,
            bottom = innerPadding.calculateBottomPadding(),
            start = 12.dp,
            end = 12.dp
        )
        ){

            Column {
                Text(text = "Trending Anime", fontWeight = FontWeight.ExtraBold, fontSize = 32.sp)
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(state.animes.size) { index ->
                        AnimeCard2(
                            anime = state.animes[index],
                            modifier = Modifier
                                .clickable {
                                    onEvent(AnimesEvent.OnAnimeItemClicked(index))
                                }

                        )
                    }
                }
            }

            if (state.isLoading) {
                AnimatedLoading(modifier = Modifier.align(Alignment.Center).size(100.dp))
            }
        }

    }
}

@Preview
@Composable
fun AnimesContentPreview() {
    AnimesContent(
        state = AnimesState(),
        onEvent = {}
    )
}