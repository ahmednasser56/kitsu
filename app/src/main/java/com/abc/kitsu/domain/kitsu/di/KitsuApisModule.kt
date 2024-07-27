package com.abc.kitsu.domain.kitsu.di

import com.abc.kitsu.data.remote.KitsuApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KitsuApisModule {

    @Singleton
    @Provides
    fun provideKitsuApi(retrofit: Retrofit): KitsuApi =
        retrofit.create(KitsuApi::class.java)

}