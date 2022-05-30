package com.example.youtubekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubekotlin.R
import com.example.youtubekotlin.model.Feed
import com.example.youtubekotlin.model.Shorts
import com.google.android.material.imageview.ShapeableImageView


/**
 * Created by Eldor Turgunov on 30.05.2022.
 * YouTube Kotlin
 * eldorturgunov777@gmail.com
 */
class FeedAdapter(
    var context: Context,
    var items: ArrayList<Feed>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var ITEM_VIEW = 0
    var ITEM_LIST = 1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_VIEW) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_feed_video, parent, false)
            return FeedViewHolder(view)
        }
        val shorts = LayoutInflater.from(context).inflate(R.layout.item_shorts_list, parent, false)
        return ShortsViewHolder(shorts)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = items[position]
        if (holder is FeedViewHolder) {
            holder.iv_profile?.setImageResource(data.profile)
            holder.iv_video?.setImageResource(data.photo)
        }
        if (holder is ShortsViewHolder) {
            val recyclerView: RecyclerView? = holder.recyclerView
            recyclerView?.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            val list: java.util.ArrayList<Shorts> = java.util.ArrayList<Shorts>()
            val adapter = ShortsAdapter(context, list)

            recyclerView!!.adapter = adapter
            list.add(Shorts(R.drawable.im_user_1, "Eldor", "Turgunov"))
            list.add(Shorts(R.drawable.im_user_2, "Eldor", "Turgunov"))
            list.add(Shorts(R.drawable.im_user_3, "Eldor", "Turgunov"))
            list.add(Shorts(R.drawable.im_user_1, "Eldor", "Turgunov"))
            list.add(Shorts(R.drawable.im_user_1, "Eldor", "Turgunov"))
            list.add(Shorts(R.drawable.im_user_2, "Eldor", "Turgunov"))
            list.add(Shorts(R.drawable.im_user_3, "Eldor", "Turgunov"))
            list.add(Shorts(R.drawable.im_user_1, "Eldor", "Turgunov"))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position].shorts != null) return ITEM_LIST
        else return ITEM_VIEW
    }

    open class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ShapeableImageView? = null
        var iv_video: ImageView? = null

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
            iv_video = itemView.findViewById(R.id.iv_video)
        }
    }

    open class ShortsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView? = null

        init {
            recyclerView = itemView.findViewById(R.id.shorts_recyclerView)
        }
    }
}