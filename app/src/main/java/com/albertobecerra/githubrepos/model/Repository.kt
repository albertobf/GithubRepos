package com.albertobecerra.githubrepos.model

import com.squareup.moshi.Json

data class Repository (
    val id: Long,
    val name: String,
    val description: String,
    val forks: Int,
    @Json(name = "stargazers_count")
    val stars: Int,
    val watchers: Int
)