package com.albertobecerra.githubrepos.network

import com.albertobecerra.githubrepos.model.Repository
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://api.github.com/"

object NULL_TO_EMPTY_STRING_ADAPTER {
    @FromJson
    fun fromJson(reader: JsonReader): String {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextString()
        }
        reader.nextNull<Unit>()
        return ""
    }
}

interface GitHubApiService {
    @GET("/users/{username}/repos")
    suspend fun repositoriesUser(@Path("username") user: String): Response<List<Repository>>
}