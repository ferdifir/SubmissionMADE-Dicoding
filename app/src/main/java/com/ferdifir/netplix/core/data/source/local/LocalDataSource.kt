package com.ferdifir.netplix.core.data.source.local

import androidx.lifecycle.LiveData
import com.ferdifir.netplix.core.data.source.local.entity.SportEntity
import com.ferdifir.netplix.core.data.source.local.room.SportDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val sportDao: SportDao){

    fun getAllSport(): Flow<List<SportEntity>> = sportDao.getAllSport()

    fun getFavoriteSport(): Flow<List<SportEntity>> = sportDao.getFavoriteSport()

    suspend fun insertSport(sportList: List<SportEntity>) = sportDao.insertSport(sportList)

    fun setFavoriteSport(sport: SportEntity, newState: Boolean) {
        sport.strLiked = newState
        sportDao.updateFavoriteSport(sport)
    }

}