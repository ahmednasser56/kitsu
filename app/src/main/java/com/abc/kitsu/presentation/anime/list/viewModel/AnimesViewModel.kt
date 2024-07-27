package com.abc.kitsu.presentation.anime.list.viewModel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.abc.kitsu.domain.kitsu.usecase.GetAnimesUseCase
import com.abc.kitsu.presentation.anime.list.event.AnimesEvent
import com.abc.kitsu.presentation.anime.list.state.AnimesState
import com.abc.kitsu.presentation.common.Resource
import com.abc.kitsu.presentation.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimesViewModel @Inject constructor(
    private val getAnimesUseCase: GetAnimesUseCase
) : BaseViewModel() {


    var state by mutableStateOf(AnimesState())

    init {
        getAnimes()
    }

    fun onEvent(context: Context, event: AnimesEvent) = viewModelScope.launch {
        when (event) {

            is AnimesEvent.OnAnimeItemClicked -> {

            }

        }
    }

    private fun getAnimes() = viewModelScope.launch {
        getAnimesUseCase.invoke().collect { result ->
            when (result) {
                is Resource.Loading -> {
                    state = state.copy(isLoading = true)
                }

                is Resource.Success -> {
                    state = state.copy(animes = result.data, isLoading = false)
                }

                is Resource.Error -> {
                    state = state.copy(isLoading = false)
                    errorFlow.emit(result.error.message)
                }
            }
        }
    }

}