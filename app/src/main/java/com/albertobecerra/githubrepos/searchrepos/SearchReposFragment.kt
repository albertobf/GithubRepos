package com.albertobecerra.githubrepos.searchrepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.albertobecerra.githubrepos.R
import com.albertobecerra.githubrepos.databinding.SearchReposBinding

class SearchReposFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: SearchReposBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.search_repos,
            container,
            false
        )

        val viewModel = ViewModelProviders.of(this).get(SearchReposViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.formValid.observe(this, Observer {isValid ->
            if(isValid) {
                findNavController().navigate(R.id.action_searchReposFragment_to_listReposFragment2)
            } else {
                binding.repositoryNameText.error = "This field can't be empty"
            }
        })
        return binding.root
    }

}