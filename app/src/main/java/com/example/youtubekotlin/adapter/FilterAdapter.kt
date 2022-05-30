package com.example.youtubekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubekotlin.R
import com.example.youtubekotlin.model.Filter


/**
 * Created by Eldor Turgunov on 30.05.2022.
 * YouTube Kotlin
 * eldorturgunov777@gmail.com
 */
class FilterAdapter(
    var context: Context,
    var items: ArrayList<Filter>
) : RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {
    val TYPE_ITEM_HEADER: Int = 0


    open class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_title: TextView? = null

        init {
            tv_title = itemView.findViewById(R.id.tv_title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        if (viewType == TYPE_ITEM_HEADER) {
            val header: View =
                LayoutInflater.from(context).inflate(R.layout.item_first_feed_filter, parent, false)
            return FilterFirstViewHolder(header)
        }
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item_feed_filter, parent, false)
        return FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        if (isHeader(position)) return
        val data = items[position]
        holder.tv_title?.text = data.title
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private class FilterFirstViewHolder(view: View?) :
        FilterViewHolder(view!!)

    override fun getItemViewType(position: Int): Int {
        return if (isHeader(position)) TYPE_ITEM_HEADER else position
    }

    fun isHeader(position: Int): Boolean {
        return position == 0
    }
}