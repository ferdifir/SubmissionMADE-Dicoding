package com.ferdifir.netplix.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.ferdifir.netplix.core.data.source.local.entity.SportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SportDao {
    @Query("SELECT * FROM sport")
    fun getAllSport(): Flow<List<SportEntity>>

    @Query("SELECT * FROM sport where isLiked = 1")
    fun getFavoriteSport(): Flow<List<SportEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun insertSport(sport: List<SportEntity>)

    @Update
    fun updateFavoriteSport(sport: SportEntity)
}