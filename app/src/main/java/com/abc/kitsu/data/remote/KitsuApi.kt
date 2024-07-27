package com.abc.kitsu.data.remote

import com.abc.kitsu.data.model.AnimesResponse
import retrofit2.http.GET

interface KitsuApi {

    @GET("trending/anime")
    suspend fun getAnimes(): AnimesResponse
}