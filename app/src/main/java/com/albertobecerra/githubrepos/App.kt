package com.albertobecerra.githubrepos

import android.app.Application
import com.albertobecerra.githubrepos.di.AppComponent
import com.albertobecerra.githubrepos.di.DaggerAppComponent

class App : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}