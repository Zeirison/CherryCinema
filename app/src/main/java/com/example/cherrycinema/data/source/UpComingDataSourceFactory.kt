package com.example.cherrycinema.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.cherrycinema.data.remote.model.Movie

class UpComingDataSourceFactory(private val newsDataSource: UpComingDataSource) :
    DataSource.Factory<Int, Movie>() {

    val liveData = MutableLiveData<UpComingDataSource>()

    override fun create(): DataSource<Int, Movie> {
        liveData.postValue(newsDataSource)
        return newsDataSource
    }

}