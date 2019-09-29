package com.albertobecerra.githubrepos.repository

import com.albertobecerra.githubrepos.model.Repository
import com.albertobecerra.githubrepos.network.GitHubApiService
import retrofit2.Response
import javax.inject.Inject

class GHRepositoriesRepository @Inject constructor(private val gitHubApiService: GitHubApiService) {
    suspend fun getUserRepositories(user: String) : Response<List<Repository>> = gitHubApiService.repositoriesUser(user)
}