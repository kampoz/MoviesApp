package com.kamil.moviesapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kamil.moviesapp.R
import com.kamil.moviesapp.model.RecyclerData
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var items = ArrayList<RecyclerData>()

    fun setListData(videos: ArrayList<RecyclerData>) {
        this.items = videos
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return MyViewHolder(inflater, parent.context)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(
        private val view: View,
        private val context: Context
    ) : RecyclerView.ViewHolder(view) {

        private val clContainer: ConstraintLayout = view.clContainer
        private val tvTitle: TextView = view.tvTitle
        private val tvCategory: TextView = view.tvCategory
        private val ivThumb: ImageView = view.ivThumb

        fun bind(dataItem: RecyclerData) {
            tvTitle.text = dataItem.title
            tvCategory.text = dataItem.category
            Glide.with(context)
                .load(dataItem.thumb)
                .centerCrop()
                .into(ivThumb)

            clContainer.setOnClickListener {
                (context as MainActivity).startVideoActivity()
            }
        }

    }
}
