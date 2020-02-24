package com.example.cherrycinema.ui.movieList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.cherrycinema.data.adapter.MoviesAdapter
import com.example.cherrycinema.data.remote.network.Status
import com.example.cherrycinema.databinding.FragmentMovieListBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: MoviesAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMovieListBinding.inflate(inflater, container, false)
        context ?: return binding.movies.rootView

        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(MovieListViewModel::class.java)

        binding.movies.adapter = adapter

        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.status.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = when (it) {
                Status.LOADING -> View.VISIBLE
                else -> View.GONE
            }
        }

        return binding.movies.rootView
    }

}