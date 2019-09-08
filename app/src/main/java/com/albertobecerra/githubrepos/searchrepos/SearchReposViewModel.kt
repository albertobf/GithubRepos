package com.albertobecerra.githubrepos.searchrepos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchReposViewModel : ViewModel() {

    private val _repositoryOwner = MutableLiveData<String>()
    private val _formValid = MutableLiveData<Boolean>()
    val repositoryName = MutableLiveData<String>()
    val repositoryOwner: LiveData<String>
        get() = _repositoryOwner
    val formValid: LiveData<Boolean>
        get() = _formValid

    init {
        repositoryName.value = ""
    }

    fun onClick() {
        repositoryName.value?.let {
            _formValid.value = it.isNotEmpty()
        }
    }

}