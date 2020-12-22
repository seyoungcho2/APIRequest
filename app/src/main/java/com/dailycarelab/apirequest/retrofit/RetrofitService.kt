package com.dailycarelab.apirequest.retrofit

import com.dailycarelab.apirequest.dto.PlayerList
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("api/player")
    fun requestList(
        @Query("name") name: String
    ) : Call<PlayerList>
}