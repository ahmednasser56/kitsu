package com.abc.kitsu.domain.kitsu.di

import com.abc.kitsu.data.remote.KitsuApi
import com.abc.kitsu.data.repository.KitsuRepositoryImpl
import com.abc.kitsu.domain.kitsu.repository.KitsuRepository
import com.abc.kitsu.presentation.common.utils.NetworkUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KitsuRepositoriesModule {

    @Provides
    @Singleton
    fun provideKitsuRepository(networkUtility: NetworkUtility, kitsuApi: KitsuApi): KitsuRepository =
        KitsuRepositoryImpl(networkUtility, kitsuApi)
}