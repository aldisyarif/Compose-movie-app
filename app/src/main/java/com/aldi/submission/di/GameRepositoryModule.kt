package com.aldi.submission.di

import com.aldi.submission.data.remote.ApiService
import com.aldi.submission.repository.GamekuRepositoryImpl
import com.aldi.submission.repository.IGamekuRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object GameRepositoryModule {

    @Provides
    fun provideRepository(
        service: ApiService
    ): IGamekuRepository = GamekuRepositoryImpl(service)
}