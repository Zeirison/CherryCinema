package com.example.cherrycinema.di

import com.example.cherrycinema.ui.movieList.MovieListAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun provideMovieAdapter() = MovieListAdapter()

}