package com.ferdifir.netplix.core.domain.usecase

import androidx.lifecycle.LiveData
import com.ferdifir.netplix.core.data.Resource
import com.ferdifir.netplix.core.domain.model.Sport
import com.ferdifir.netplix.core.domain.repository.ISportRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SportInteractor @Inject constructor(private val sportRepository: ISportRepository): SportUseCase {
    override fun getAllSport(): Flow<Resource<List<Sport>>> = sportRepository.getAllSport()

    override fun getFavoriteSport(): Flow<List<Sport>> = sportRepository.getFavoriteSport()

    override fun setFavoriteSport(sport: Sport, state: Boolean) = sportRepository.setFavoriteSport(sport, state)

}