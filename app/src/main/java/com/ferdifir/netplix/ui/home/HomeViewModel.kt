package com.ferdifir.netplix.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ferdifir.netplix.core.domain.usecase.SportUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(sportUseCase: SportUseCase) : ViewModel() {
    val sport = sportUseCase.getAllSport().asLiveData()
}