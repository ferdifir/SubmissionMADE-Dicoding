package com.ferdifir.netplix.core.domain.usecase

import androidx.lifecycle.LiveData
import com.ferdifir.netplix.core.data.Resource
import com.ferdifir.netplix.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface SportUseCase {
    fun getAllSport(): Flow<Resource<List<Sport>>>
    fun getFavoriteSport(): Flow<List<Sport>>
    fun setFavoriteSport(sport: Sport, state: Boolean)
}