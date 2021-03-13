package com.kamil.moviesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.kamil.moviesapp.data.repository.MoviesRepository
import com.kamil.moviesapp.model.RecyclerData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentMoviesViewModel(
    private var repository: MoviesRepository
) : MoviesViewModel() {

    var recyclerListData: MutableLiveData<ArrayList<RecyclerData>> = MutableLiveData()

    fun getMovies() {
        GlobalScope.launch(Dispatchers.Main) {
            recyclerListData.postValue(repository.getMovies())
        }
    }
}