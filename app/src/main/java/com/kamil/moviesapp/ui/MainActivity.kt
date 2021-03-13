package com.kamil.moviesapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kamil.moviesapp.R
import com.kamil.moviesapp.ui.viewmodel.CurrentMoviesViewModel
import com.kamil.moviesapp.ui.viewmodel.CurrentMoviesViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: CurrentMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = CurrentMoviesViewModelFactory().create(CurrentMoviesViewModel::class.java)
        viewModel.recyclerListData.observe(this, {
            recyclerViewAdapter.setListData(it)
            recyclerViewAdapter.notifyDataSetChanged()
        })

        initRecyclerView()

        val etSearch: EditText = findViewById(R.id.etSearch)

        etSearch.addTextChangedListener(MyTextWatcher(viewModel))
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.rvMovies)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            val decoration =
                DividerItemDecoration(applicationContext, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }
    }

    fun startVideoActivity() {
        val intent = Intent(this, VideoActivity::class.java)
        startActivity(intent)
    }
}