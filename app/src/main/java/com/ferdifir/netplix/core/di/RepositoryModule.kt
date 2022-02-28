package com.ferdifir.netplix.core.di

import com.ferdifir.netplix.core.data.SportRepository
import com.ferdifir.netplix.core.domain.repository.ISportRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(sportRepository: SportRepository): ISportRepository

}