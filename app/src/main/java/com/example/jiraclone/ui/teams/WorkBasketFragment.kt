package com.example.jiraclone.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.HomeActivity
import com.example.jiraclone.HomeViewModel
import com.example.jiraclone.R
import com.example.jiraclone.databinding.FragmentNewTeamCreateBinding
import com.example.jiraclone.databinding.FragmentWorkBasketBinding
import com.example.jiraclone.ui.BaseFragment

class WorkBasketFragment: BaseFragment() {

    private var viewModel: HomeViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val workBasketBinding = DataBindingUtil
            .inflate<FragmentWorkBasketBinding>(inflater, R.layout.fragment_work_basket, container, false)

        activity?.let {
            context?.resources?.getString(R.string.work_basket)?.let {title ->
                setToolbarText(title)
            }
            viewModel = if(it is HomeActivity) it.activityViewModel else null
        }

        return workBasketBinding.root
    }


    companion object {
        fun newInstance() = WorkBasketFragment()
    }
}