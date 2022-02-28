package com.ferdifir.netplix.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ferdifir.netplix.core.data.source.local.LocalDataSource
import com.ferdifir.netplix.core.data.source.remote.RemoteDataSource
import com.ferdifir.netplix.core.data.source.remote.network.ApiResponse
import com.ferdifir.netplix.core.data.source.remote.response.SportsResponse
import com.ferdifir.netplix.core.domain.model.Sport
import com.ferdifir.netplix.core.domain.repository.ISportRepository
import com.ferdifir.netplix.core.utils.AppExecutors
import com.ferdifir.netplix.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SportRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISportRepository {

    override fun getAllSport(): Flow<Resource<List<Sport>>> =
        object : NetworkBoundResource<List<Sport>, List<SportsResponse>>() {
            override fun loadFromDB(): Flow<List<Sport>> {
                return localDataSource.getAllSport().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Sport>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<SportsResponse>>> =
                remoteDataSource.getListSport()

            override suspend fun saveCallResult(data: List<SportsResponse>) {
                val sportList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSport(sportList)
            }

        }.asFlow()


    override fun getFavoriteSport(): Flow<List<Sport>> {
        return localDataSource.getFavoriteSport().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteSport(sport: Sport, state: Boolean) {
        val sportEntity = DataMapper.mapDomainToEntity(sport)
        appExecutors.diskIO().execute { localDataSource.setFavoriteSport(sportEntity, state) }
    }
}