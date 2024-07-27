package com.abc.kitsu.domain.kitsu.repository

import com.abc.kitsu.data.model.AnimesResponse
import kotlinx.coroutines.flow.Flow
import com.abc.kitsu.presentation.common.Resource


interface KitsuRepository {
    fun getAnimes(): Flow<Resource<AnimesResponse>>
}