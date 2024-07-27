package com.abc.kitsu.presentation.common.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.abc.kitsu.R
import com.abc.kitsu.data.model.ApiError
import com.abc.kitsu.presentation.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import retrofit2.HttpException
import javax.inject.Inject


class NetworkUtility @Inject constructor(
    private val applicationContext: Context
) {

    private fun isOnline(): Boolean {

        val connectivityManager: ConnectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) != null
    }

    fun <T : Any> safeApiCall(
        apiToBeCalled: suspend () -> T
    ): Flow<Resource<T>> = flow {
        try {
            if (!isOnline()) {
                emit(
                    Resource.Error(
                        ApiError(
                            NetworkError.NO_INTERNET.code,
                            applicationContext.resources.getString(R.string.msg_no_network)
                        )
                    )
                )
            } else {
                emit(Resource.Loading())
                val response = apiToBeCalled.invoke()
                emit(Resource.Success(response))
            }
        } catch (ex: Exception) {
            Log.d("GetCostTimeUseCase", ex.toString())

            emit(Resource.Error(handleNetworkException(ex)))
        }
    }

    private fun handleNetworkException(ex: Exception): ApiError {
        return if (ex is HttpException) {
            ApiError(ex.code(), getErrorMessage(ex.code(), ex.response()?.errorBody()))
        } else {
            ApiError(
                NetworkError.UNKNOWN_ERROR.code,
                applicationContext.resources.getString(R.string.msg_can_not_get_data)
            )
        }
    }

    private fun getErrorMessage(responseCode: Int, responseBody: ResponseBody?): String {
        when (responseCode) {

            NetworkError.BAD_REQUEST.code -> return applicationContext.resources.getString(R.string.msg_bad_request)

            NetworkError.UNAUTHORIZED.code -> return applicationContext.resources.getString(R.string.msg_unauthorized_user)

            NetworkError.FORBIDDEN.code -> return applicationContext.resources.getString(R.string.msg_forbidden_user)

            NetworkError.NOT_FOUND.code -> return applicationContext.resources.getString(R.string.msg_no_data)

            NetworkError.TIMEOUT.code -> return applicationContext.resources.getString(R.string.msg_timeout)

            NetworkError.TOO_MANY_REQUESTS.code -> return applicationContext.resources.getString(R.string.msg_too_many_requests)

            NetworkError.CONFLICT.code -> return applicationContext.resources.getString(R.string.msg_conflict)

            NetworkError.INTERNAL_SERVER_ERROR.code -> return applicationContext.resources.getString(
                R.string.msg_internal_service_error
            )

            else -> return applicationContext.resources.getString(R.string.msg_can_not_get_data)

        }
    }
}

enum class NetworkError(val code: Int) {
    NO_INTERNET(1000),
    UNKNOWN_ERROR(3000),
    DATA_ERROR(4000),

    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    TIMEOUT(408),
    CONFLICT(409),
    TOO_MANY_REQUESTS(429),
    INTERNAL_SERVER_ERROR(500),
}
