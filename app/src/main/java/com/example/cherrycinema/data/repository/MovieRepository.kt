package com.example.cherrycinema.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.cherrycinema.data.remote.model.Movie
import com.example.cherrycinema.data.remote.network.Status
import com.example.cherrycinema.data.source.UpComingDataSource
import com.example.cherrycinema.data.source.UpComingDataSourceFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val dataSourceFactory: UpComingDataSourceFactory
) {

    fun getStatus() = Transformations.switchMap<UpComingDataSource, Status>(
        dataSourceFactory.liveData,
        UpComingDataSource::status
    )

    fun getUpcoming(): LiveData<PagedList<Movie>> {
        val result = dataSourceFactory
        return LivePagedListBuilder(result, pagedListConfig()).build()
    }

    private fun pagedListConfig() = PagedList.Config.Builder().build()

}