package com.example.youtubekotlin.model


/**
 * Created by Eldor Turgunov on 30.05.2022.
 * YouTube Kotlin
 * eldorturgunov777@gmail.com
 */
data class Feed(
    var profile: Int,
    var photo: Int,
    var shorts: List<Shorts>?
)
