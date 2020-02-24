package com.example.cherrycinema.di

import com.example.cherrycinema.data.repository.MovieRepository
import com.example.cherrycinema.data.source.UpComingDataSourceFactory
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideMovieRepository(
        dataSourceFactory: UpComingDataSourceFactory
    ) = MovieRepository(dataSourceFactory)

}