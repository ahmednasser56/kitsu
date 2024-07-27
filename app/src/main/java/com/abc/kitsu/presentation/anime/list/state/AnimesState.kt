package com.abc.kitsu.presentation.anime.list.state

import com.abc.kitsu.domain.kitsu.model.Anime


data class AnimesState(
    val animes: List<Anime> = emptyList(),
    val isLoading: Boolean = false
)
