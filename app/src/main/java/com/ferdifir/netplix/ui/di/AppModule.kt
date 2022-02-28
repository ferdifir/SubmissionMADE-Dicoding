package com.ferdifir.netplix.ui.di

import com.ferdifir.netplix.core.domain.usecase.SportInteractor
import com.ferdifir.netplix.core.domain.usecase.SportUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideTourismUseCase(sportInteractor: SportInteractor): SportUseCase

}