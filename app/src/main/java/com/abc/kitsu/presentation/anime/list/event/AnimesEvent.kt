package com.abc.kitsu.presentation.anime.list.event

sealed class AnimesEvent {

    data class OnAnimeItemClicked(val position: Int) : AnimesEvent()
}