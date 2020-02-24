package com.example.cherrycinema.ui.movieList

import androidx.lifecycle.ViewModel
import com.example.cherrycinema.data.repository.MovieRepository
import javax.inject.Inject


class MovieListViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {

    val movies by lazy { repository.getUpcoming() }

    val status = repository.getStatus()

}