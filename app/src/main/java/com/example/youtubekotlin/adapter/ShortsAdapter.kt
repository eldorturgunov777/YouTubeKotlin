package com.example.youtubekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubekotlin.R
import com.example.youtubekotlin.model.Shorts


/**
 * Created by Eldor Turgunov on 30.05.2022.
 * YouTube Kotlin
 * eldorturgunov777@gmail.com
 */
class ShortsAdapter(
    var context: Context,
    var items: ArrayList<Shorts>
) : RecyclerView.Adapter<ShortsAdapter.ShortsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShortsAdapter.ShortsViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item_shorts_video, parent, false)
        return ShortsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShortsAdapter.ShortsViewHolder, position: Int) {
        val data = items[position]

        holder.img?.setImageResource(data.img)
        holder.title?.setText(data.title)
        holder.desc?.setText(data.desc)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ShortsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView? = null
        var title: TextView? = null
        var desc: TextView? = null

        init {
            img = itemView.findViewById(R.id.shorts)
            title = itemView.findViewById(R.id.tv_shorts)
            desc = itemView.findViewById(R.id.tv_desc_shorts)
        }

    }


}