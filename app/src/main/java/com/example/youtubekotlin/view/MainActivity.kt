package com.example.youtubekotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubekotlin.R
import com.example.youtubekotlin.adapter.FeedAdapter
import com.example.youtubekotlin.adapter.FilterAdapter
import com.example.youtubekotlin.model.Feed
import com.example.youtubekotlin.model.Filter
import com.example.youtubekotlin.model.Shorts

class MainActivity : AppCompatActivity() {
    var recyclerFilter: RecyclerView? = null
    var recyclerFeed: RecyclerView? = null
    var filter: ArrayList<Filter> = ArrayList<Filter>()
    var feed: ArrayList<Feed> = ArrayList<Feed>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerFilter?.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed?.setLayoutManager(GridLayoutManager(this, 1))
        val filterAdapter = FilterAdapter(this, filter)
        recyclerFilter?.setAdapter(filterAdapter)
        filterData()
        val feedAdapter = FeedAdapter(this, feed)
        recyclerFeed?.setAdapter(feedAdapter)
        feedData()
    }

    private fun feedData() {
        feed.add(Feed(R.drawable.im_user_1, R.drawable.im_video_1, null))
        feed.add(Feed(R.drawable.im_user_2, R.drawable.im_video_2, shorts()))
        feed.add(Feed(R.drawable.im_user_3, R.drawable.im_video_3, null))
        feed.add(Feed(R.drawable.im_user_1, R.drawable.im_video_1, null))
        feed.add(Feed(R.drawable.im_user_2, R.drawable.im_video_2, null))
        feed.add(Feed(R.drawable.im_user_3, R.drawable.im_video_3, null))
    }

    private fun shorts(): java.util.ArrayList<Shorts> {
        val list: ArrayList<Shorts> = ArrayList<Shorts>()
        list.add(Shorts(R.drawable.im_user_1, "Eldor", "Turgunov"))
        list.add(Shorts(R.drawable.im_user_2, "Eldor", "Turgunov"))
        list.add(Shorts(R.drawable.im_user_3, "Eldor", "Turgunov"))
        list.add(Shorts(R.drawable.im_user_1, "Eldor", "Turgunov"))
        return list
    }

    private fun filterData() {
        filter.add(Filter("Android"))
        filter.add(Filter("Java"))
        filter.add(Filter("Kotlin"))
        filter.add(Filter("Pc"))
        filter.add(Filter("Phone"))
        filter.add(Filter("Android"))
        filter.add(Filter("Java"))
        filter.add(Filter("Kotlin"))
        filter.add(Filter("Pc"))
        filter.add(Filter("Phone"))
        filter.add(Filter("Android"))
        filter.add(Filter("Java"))
        filter.add(Filter("Kotlin"))
        filter.add(Filter("Pc"))
        filter.add(Filter("Phone"))
        filter.add(Filter("Android"))
        filter.add(Filter("Java"))
        filter.add(Filter("Kotlin"))
        filter.add(Filter("Pc"))
        filter.add(Filter("Phone"))
    }
}