package com.abc.kitsu.presentation.common.di

import android.content.Context
import com.abc.kitsu.presentation.common.utils.NetworkUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UtilitiesModule {

    @Singleton
    @Provides
    fun provideNetworkUtility(
        @ApplicationContext applicationContext: Context
    ) =
        NetworkUtility(applicationContext)


}