package com.example.cherrycinema.di

import com.example.cherrycinema.data.remote.api.MovieService
import com.example.cherrycinema.data.source.UpComingDataSource
import com.example.cherrycinema.data.source.UpComingDataSourceFactory
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {

    @Provides
    fun provideUpComingDataSource(
        movieService: MovieService
    ) = UpComingDataSource(movieService)

    @Provides
    fun provideUpComingDataSourceFactory(
        dataSource: UpComingDataSource
    ) = UpComingDataSourceFactory(dataSource)

}