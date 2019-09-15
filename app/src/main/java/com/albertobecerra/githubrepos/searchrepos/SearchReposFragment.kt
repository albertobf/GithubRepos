package com.albertobecerra.githubrepos.searchrepos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
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
                val repositoryOwnerName = binding.repositoryNameText.text.toString()
                val action = SearchReposFragmentDirections.actionSearchReposFragmentToListReposFragment2(repositoryOwnerName)
                findNavController().navigate(action)
                activity?.let {
                    hideKeyboard(it)
                }
            } else {
                binding.repositoryNameText.error = "This field can't be empty"
            }
        })
        return binding.root
    }

    private fun hideKeyboard(it: FragmentActivity): Boolean {
        val imm = it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.hideSoftInputFromWindow(it.currentFocus?.windowToken, 0)
    }

}