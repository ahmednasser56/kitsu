package com.abc.kitsu.domain.kitsu.usecase

import com.abc.kitsu.data.model.ApiError
import com.abc.kitsu.data.model.toAnime
import com.abc.kitsu.domain.kitsu.model.Anime
import com.abc.kitsu.domain.kitsu.repository.KitsuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.abc.kitsu.presentation.common.Resource
import javax.inject.Inject

class GetAnimesUseCase @Inject constructor(
    private val repository: KitsuRepository
) {

    operator fun invoke(): Flow<Resource<List<Anime>>> = flow {

        repository.getAnimes().collect { result ->

            when (result) {
                is Resource.Loading -> {
                    emit(Resource.Loading())
                }

                is Resource.Success -> {
                    try {
                        emit(Resource.Success(result.data.animeDto.map { it.toAnime() }))
                    } catch (e: Exception) {
                        emit(Resource.Error(ApiError(1, "Error getting the data")))
                    }
                }

                is Resource.Error -> {
                    emit(Resource.Error(result.error))
                }
            }
        }
    }

}