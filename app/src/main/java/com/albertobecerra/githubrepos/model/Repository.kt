package com.albertobecerra.githubrepos.model

data class Repository (
    val id: Long,
    val name: String,
    val description: String,
    val forks: Int,
    val stars: Int,
    val watchers: Int
)