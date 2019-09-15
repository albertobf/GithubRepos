package com.albertobecerra.githubrepos.repository

import com.albertobecerra.githubrepos.network.GitHubApi

class GHRepositoriesRepository {
    private val gitHubApiService = GitHubApi.retrofitService

    suspend fun getUserRepositories(user: String) = gitHubApiService.repositoriesUser(user)
}