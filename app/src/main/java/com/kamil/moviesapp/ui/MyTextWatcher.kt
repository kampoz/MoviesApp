package com.kamil.moviesapp.ui

import android.text.Editable
import android.text.TextWatcher
import com.kamil.moviesapp.ui.viewmodel.CurrentMoviesViewModel

class MyTextWatcher(private val viewModel: CurrentMoviesViewModel) : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
        if (s?.length!! > 2)
            viewModel.getMovies()
    }
}