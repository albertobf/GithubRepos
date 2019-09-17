package com.albertobecerra.githubrepos.listrepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.albertobecerra.githubrepos.R
import com.albertobecerra.githubrepos.databinding.ListReposBinding

class ListReposFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: ListReposBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_repos,
            container,
            false
        )
        val viewModel = ViewModelProviders.of(this).get(ListReposViewModel::class.java)
        val repositoryOwnerName = ListReposFragmentArgs.fromBundle(requireArguments()).name
        val adapter = RepositoryListAdapter()
        val itemDecoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        binding.repositoriesList.adapter = adapter
        binding.repositoriesList.addItemDecoration(itemDecoration)
        viewModel.getRepositories(repositoryOwnerName)

        viewModel.repositoriesList.observe(this, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        viewModel.error.observe(this, Observer {
            it?.let {
                binding.error = it
                binding.repositoryListError.visibility = View.VISIBLE
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }

        return binding.root
    }

}