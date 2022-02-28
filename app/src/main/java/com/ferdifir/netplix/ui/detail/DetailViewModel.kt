package com.ferdifir.netplix.ui.detail

import androidx.lifecycle.ViewModel
import com.ferdifir.netplix.core.domain.model.Sport
import com.ferdifir.netplix.core.domain.usecase.SportUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val sportUseCase: SportUseCase) : ViewModel() {
    fun setFavoriteSport(sport: Sport, newStatus:Boolean) =
        sportUseCase.setFavoriteSport(sport, newStatus)
}