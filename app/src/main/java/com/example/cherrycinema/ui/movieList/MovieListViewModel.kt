package com.example.cherrycinema.ui.movieList

import androidx.lifecycle.ViewModel
import com.example.cherrycinema.data.repository.MovieRepository
import javax.inject.Inject


class MovieListViewModel @Inject constructor(repository: MovieRepository) :
    ViewModel() {

    val status = repository.getStatus()
    val movies = repository.getMovies()

}