package com.example.cherrycinema.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.cherrycinema.data.remote.api.MovieService
import com.example.cherrycinema.data.remote.model.Movie
import com.example.cherrycinema.data.remote.network.Resource
import com.example.cherrycinema.data.remote.network.ResponseHandler
import com.example.cherrycinema.data.remote.network.Status
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpComingDataSource @Inject constructor(
    private val movieService: MovieService
) : PageKeyedDataSource<Int, Movie>() {

    var status: MutableLiveData<Status> = MutableLiveData()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        updateStatus(Status.LOADING)
        loadData(1) {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Movie>
    ) {
        updateStatus(Status.LOADING)
        val page = params.key
        loadData(page) {
            callback.onResult(it, page + 1)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Movie>
    ) {
        updateStatus(Status.LOADING)
        val page = params.key
        loadData(page) {
            callback.onResult(it, page - 1)
        }
    }

    private fun loadData(
        page: Int,
        callback: (List<Movie>) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val responseHandler = ResponseHandler()
            val response: Resource<List<Movie>> = try {
                val result = movieService.getUpcoming(page)
                responseHandler.handleSuccess(result.results)
            } catch (e: Exception) {
                responseHandler.handleException(e)
            }

            if (response.status == Status.SUCCESS) {
                updateStatus(Status.SUCCESS)
                val result = response.response
                result?.let { callback(it) }
            } else if (response.status == Status.ERROR) {
                updateStatus(Status.ERROR)
            }
        }
    }

    private fun updateStatus(status: Status) {
        this.status.postValue(status)
    }

}