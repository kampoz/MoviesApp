package com.kamil.moviesapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kamil.moviesapp.data.repository.MoviesRepository


@Suppress("UNCHECKED_CAST")
class CurrentMoviesViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        // injecting MoviesRepository should be done by Dependency Injection
        return CurrentMoviesViewModel(MoviesRepository()) as T
    }
}