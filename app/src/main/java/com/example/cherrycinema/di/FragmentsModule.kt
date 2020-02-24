package com.example.cherrycinema.di

import com.example.cherrycinema.ui.movieList.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment

}