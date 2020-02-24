package com.example.cherrycinema.di

import com.example.cherrycinema.data.adapter.MoviesAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun provideMovieAdapter() = MoviesAdapter()

}