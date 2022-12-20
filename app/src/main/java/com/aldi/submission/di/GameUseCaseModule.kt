package com.aldi.submission.di

import com.aldi.submission.repository.IGamekuRepository
import com.aldi.submission.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object GameUseCaseModule {

    @Provides
    fun provideGetAllGameUseCase(
        iGamekuRepository: IGamekuRepository
    ): GetAllGameUseCase =
        GetAllGameUseCase(iGamekuRepository)

    @Provides
    fun provideGetPlatformUseCase(
        iGamekuRepository: IGamekuRepository
    ): GetPlatformUseCase =
        GetPlatformUseCase(iGamekuRepository)

    @Provides
    fun provideGetRandomUseCase(
        iGamekuRepository: IGamekuRepository
    ): GetRandomUseCase =
        GetRandomUseCase(iGamekuRepository)

    @Provides
    fun provideGetAllGamesByOrderingUseCase(
        iGamekuRepository: IGamekuRepository
    ): GetAllGamesByOrderingUseCase =
        GetAllGamesByOrderingUseCase(iGamekuRepository)

    @Provides
    fun provideGetCatalogueGameListUseCase(
        iGamekuRepository: IGamekuRepository
    ): GetCatalogueGameListUseCase =
        GetCatalogueGameListUseCase(iGamekuRepository)

    @Provides
    fun provideGeDetailGameUseCase(
        iGamekuRepository: IGamekuRepository
    ): GetDetailGameUseCase =
        GetDetailGameUseCase(iGamekuRepository)
}