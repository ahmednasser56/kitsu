package com.abc.kitsu.presentation.common.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object AnimesScreenRoute

//    @Serializable
//    data class CompanyInfoRoute(
//        val company: CompanyListing
//    )
}