package com.miller.testapp_musicplayer.models

import java.net.URL
//TODO change url to string or..?
data class Video(
    val id: Long? = null,
    val name: String = "not found",
    val channel: String = "not found",
    val url: URL? = null,
)