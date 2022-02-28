package com.ferdifir.netplix.core.domain.repository

import androidx.lifecycle.LiveData
import com.ferdifir.netplix.core.data.Resource
import com.ferdifir.netplix.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface ISportRepository {
    fun getAllSport(): Flow<Resource<List<Sport>>>
    fun getFavoriteSport(): Flow<List<Sport>>
    fun setFavoriteSport(sport: Sport, state: Boolean)
}