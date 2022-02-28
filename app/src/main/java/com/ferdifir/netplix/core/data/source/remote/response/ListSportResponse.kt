package com.ferdifir.netplix.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListSportResponse(

	@field:SerializedName("sports")
	val sports: List<SportsResponse>
)

data class SportsResponse(

	@field:SerializedName("idSport")
	val idSport: String,

	@field:SerializedName("strFormat")
	val strFormat: String,

	@field:SerializedName("strSport")
	val strSport: String,

	@field:SerializedName("strSportIconGreen")
	val strSportIconGreen: String,

	@field:SerializedName("strSportThumb")
	val strSportThumb: String,

	@field:SerializedName("strSportDescription")
	val strSportDescription: String
)
