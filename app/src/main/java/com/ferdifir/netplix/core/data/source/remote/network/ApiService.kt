package com.ferdifir.netplix.core.data.source.remote.network

import com.ferdifir.netplix.core.data.source.remote.response.ListSportResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("all_sports.php")
    suspend fun getSports() : ListSportResponse

}
