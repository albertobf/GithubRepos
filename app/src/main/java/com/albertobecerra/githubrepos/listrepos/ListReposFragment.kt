package com.albertobecerra.githubrepos.listrepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.albertobecerra.githubrepos.R
import com.albertobecerra.githubrepos.databinding.ListReposBinding
import com.albertobecerra.githubrepos.model.Repository

class ListReposFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: ListReposBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_repos,
            container,
            false
        )
        val adapter = RepositoryListAdapter()
        adapter.submitList(dummyRepos())
        binding.repositoriesList.adapter = adapter
        return binding.root
    }

    fun dummyRepos() : List<Repository> {
        val repository = Repository(1, "Project name", "Project Description",
            10, 5, 20)
        return listOf(repository)
    }

}