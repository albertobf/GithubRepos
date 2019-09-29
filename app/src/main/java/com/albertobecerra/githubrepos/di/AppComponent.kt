package com.albertobecerra.githubrepos.di

import com.albertobecerra.githubrepos.listrepos.ListReposFragment
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(listReposFragment: ListReposFragment)
}