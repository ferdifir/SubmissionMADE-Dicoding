package com.ferdifir.netplix.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ferdifir.netplix.core.domain.usecase.SportUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(sportUseCase: SportUseCase) : ViewModel() {
    val favoriteSport = sportUseCase.getFavoriteSport().asLiveData()
}