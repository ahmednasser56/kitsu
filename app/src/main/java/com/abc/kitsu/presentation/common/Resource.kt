package com.abc.kitsu.presentation.common

import com.abc.kitsu.data.model.ApiError


sealed class Resource<T : Any>() {
    class Loading<T : Any> : Resource<T>()
    data class Success<T : Any>(val data: T) : Resource<T>()
    data class Error<T : Any>(val error: ApiError) : Resource<T>()
}