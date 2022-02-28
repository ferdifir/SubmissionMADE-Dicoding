package com.ferdifir.netplix.core.utils

import com.ferdifir.netplix.core.data.source.local.entity.SportEntity
import com.ferdifir.netplix.core.data.source.remote.response.SportsResponse
import com.ferdifir.netplix.core.domain.model.Sport

object DataMapper {
    fun mapResponsesToEntities(input: List<SportsResponse>): List<SportEntity> {
        val sportList = ArrayList<SportEntity>()
        input.map {
            val sport = SportEntity(
                idSport = it.idSport,
                strFormat = it.strFormat,
                strSport = it.strSport,
                strSportIconGreen = it.strSportIconGreen,
                strSportThumb = it.strSportThumb,
                strSportDescription = it.strSportDescription,
                strLiked = false
            )
            sportList.add(sport)
        }
        return sportList
    }

    fun mapEntitiesToDomain(input: List<SportEntity>): List<Sport> {
        return input.map {
            Sport(
                idSport = it.idSport,
                strFormat = it.strFormat,
                strSport = it.strSport,
                strSportIconGreen = it.strSportIconGreen,
                strSportThumb = it.strSportThumb,
                strSportDescription = it.strSportDescription,
                strLiked = it.strLiked
            )
        }
    }

    fun mapDomainToEntity(input: Sport): SportEntity {
        return SportEntity(
            idSport = input.idSport,
            strFormat = input.strFormat,
            strSport = input.strSport,
            strSportIconGreen = input.strSportIconGreen,
            strSportThumb = input.strSportThumb,
            strSportDescription = input.strSportDescription,
            strLiked = input.strLiked
        )
    }
}