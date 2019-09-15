package com.albertobecerra.githubrepos.listrepos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertobecerra.githubrepos.model.Repository
import com.albertobecerra.githubrepos.repository.GHRepositoriesRepository
import kotlinx.coroutines.launch

class ListReposViewModel : ViewModel() {
    val repository = GHRepositoriesRepository()

    private val _repositoriesList = MutableLiveData<List<Repository>>()
    val repositoriesList : LiveData<List<Repository>>
        get() = _repositoriesList

    fun getRepositories(repositoryOwnerName: String) {
        viewModelScope.launch {
            val result = repository.getUserRepositories(repositoryOwnerName)
            _repositoriesList.postValue(result)
        }
    }
}