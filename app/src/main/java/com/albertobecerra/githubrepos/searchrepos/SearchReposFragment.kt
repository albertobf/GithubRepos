package com.albertobecerra.githubrepos.searchrepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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
                Toast.makeText(activity, "OK", Toast.LENGTH_SHORT).show()
            } else {
                binding.repositoryNameText.error = "This field can't be empty"
            }
        })
        return binding.root
    }

}