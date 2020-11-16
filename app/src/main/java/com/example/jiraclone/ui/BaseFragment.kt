package com.example.jiraclone.ui

import android.view.View
import androidx.fragment.app.Fragment
import com.example.jiraclone.HomeActivity
import com.example.jiraclone.R
import com.example.jiraclone.ui.tasks.TaskListFragment
import kotlinx.android.synthetic.main.toolbar.*

open class BaseFragment: Fragment() {

    fun setToolbarText(title: String, shouldBeVisible: Boolean = true) {
        activity?.let {
            if(it is HomeActivity) {
                it.toolbar_text_id.text = title
                if(shouldBeVisible) {
                    it.toolbar_close_id.visibility = View.VISIBLE
                    it.toolbar_back_id.visibility = View.VISIBLE
                } else {
                    it.toolbar_close_id.visibility = View.GONE
                    it.toolbar_back_id.visibility = View.GONE
                }
            }
        }
    }

    fun setBackArrowClick() {
        activity?.let {
           it.toolbar_back_id.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    fun setCloseClick() {
        activity?.let {
            it.toolbar_close_id.setOnClickListener {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frameId, DashboardFragment.newInstance())
                    ?.addToBackStack(null)
                    ?.commit()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        setToolbarText("")
    }
}