package com.abc.kitsu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abc.kitsu.presentation.anime.list.view.AnimesScreen
import com.abc.kitsu.presentation.common.navigation.Routes
import com.abc.kitsu.presentation.ui.theme.KitsuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KitsuTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.AnimesScreenRoute) {
                    composable<Routes.AnimesScreenRoute> {
                        AnimesScreen(navController)
                    }

//                    composable<Routes.CompanyInfoScreen>(
//                        typeMap = mapOf(
//                            typeOf<CompanyListing>() to CustomNavType(
//                                CompanyListing::class.java,
//                                CompanyListing.serializer()
//                            )
//                        )
//                    ) {
//                        CompanyInfoScreen(navController)
//                    }
                }

            }
        }
    }
}