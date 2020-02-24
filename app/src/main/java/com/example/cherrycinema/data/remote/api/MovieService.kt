package com.example.cherrycinema.data.remote.api

import androidx.lifecycle.LiveData
import com.example.cherrycinema.data.remote.model.UpComingResult
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/upcoming")
    fun getUpcoming(
        @Query("page") page: Int
    ): LiveData<UpComingResult>

}