package com.ferdifir.netplix.core.di

import android.content.Context
import androidx.room.Room
import com.ferdifir.netplix.core.data.source.local.room.SportDao
import com.ferdifir.netplix.core.data.source.local.room.SportDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SportDatabase = Room.databaseBuilder(
        context,
        SportDatabase::class.java, "Sport.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: SportDatabase): SportDao = database.sportDao()

}