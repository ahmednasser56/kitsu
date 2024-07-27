package com.abc.kitsu.data.repository

import com.abc.kitsu.data.model.AnimesResponse
import com.abc.kitsu.data.remote.KitsuApi
import com.abc.kitsu.domain.kitsu.repository.KitsuRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.abc.kitsu.presentation.common.Resource
import com.abc.kitsu.presentation.common.utils.NetworkUtility


class KitsuRepositoryImpl @Inject constructor(
    private val networkUtility: NetworkUtility,
    private val apiService: KitsuApi
) : KitsuRepository {

    override fun getAnimes(): Flow<Resource<AnimesResponse>> =
        networkUtility.safeApiCall { apiService.getAnimes() }

}