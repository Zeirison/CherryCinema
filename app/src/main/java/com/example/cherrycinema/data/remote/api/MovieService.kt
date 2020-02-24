package com.example.cherrycinema.data.remote.api

import com.example.cherrycinema.data.remote.model.UpComingResult
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("page") page: Int
    ): UpComingResult

}