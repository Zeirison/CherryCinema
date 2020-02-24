package com.example.cherrycinema.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.cherrycinema.data.remote.model.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpComingDataSourceFactory @Inject constructor(private val dataSource: UpComingDataSource) :
    DataSource.Factory<Int, Movie>() {

    val liveData = MutableLiveData<UpComingDataSource>()

    override fun create(): DataSource<Int, Movie> {
        liveData.postValue(dataSource)
        return dataSource
    }

}