package com.abc.kitsu.domain.kitsu.di

import com.abc.kitsu.domain.kitsu.repository.KitsuRepository
import com.abc.kitsu.domain.kitsu.usecase.GetAnimesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KitsuUseCasesModule {

    @Singleton
    @Provides
    fun provideGetAnimesUseCase(
        kitsuRepository: KitsuRepository
    ) = GetAnimesUseCase(kitsuRepository)
}