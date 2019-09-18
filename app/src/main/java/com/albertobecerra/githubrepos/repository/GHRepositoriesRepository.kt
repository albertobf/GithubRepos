package com.albertobecerra.githubrepos.repository

import com.albertobecerra.githubrepos.model.Repository
import com.albertobecerra.githubrepos.network.GitHubApi
import retrofit2.Response

class GHRepositoriesRepository {
    private val gitHubApiService = GitHubApi.retrofitService

    suspend fun getUserRepositories(user: String) : Response<List<Repository>> = gitHubApiService.repositoriesUser(user)
}