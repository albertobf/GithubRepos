package com.albertobecerra.githubrepos.listrepos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.albertobecerra.githubrepos.repository.GHRepositoriesRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ListReposViewModelFactory @Inject constructor(private val repository: GHRepositoriesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListReposViewModel::class.java)) {
            return ListReposViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}