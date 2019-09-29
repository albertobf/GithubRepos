package com.albertobecerra.githubrepos.di

import com.albertobecerra.githubrepos.network.BASE_URL
import com.albertobecerra.githubrepos.network.GitHubApiService
import com.albertobecerra.githubrepos.network.NULL_TO_EMPTY_STRING_ADAPTER
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @JvmStatic
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(NULL_TO_EMPTY_STRING_ADAPTER)
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @JvmStatic
    fun providesRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @JvmStatic
    fun provideGitHubApiService(retrofit: Retrofit): GitHubApiService {
        return retrofit.create(GitHubApiService::class.java)
    }
}