package com.albertobecerra.githubrepos.listrepos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertobecerra.githubrepos.model.Repository
import com.albertobecerra.githubrepos.repository.GHRepositoriesRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ListReposViewModel @Inject constructor(private val repository: GHRepositoriesRepository) : ViewModel() {

    private val _repositoriesList = MutableLiveData<Response<List<Repository>>>()
    val repositoriesList : LiveData<Response<List<Repository>>>
        get() = _repositoriesList

    fun getRepositories(repositoryOwnerName: String) {
        viewModelScope.launch {
            _repositoriesList.postValue(repository.getUserRepositories(repositoryOwnerName))
        }
    }
}