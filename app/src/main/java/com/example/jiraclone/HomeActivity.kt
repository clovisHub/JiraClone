package com.example.jiraclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.jiraclone.databinding.ActivityHomeBinding
import com.example.jiraclone.ui.DashboardFragment
import com.example.jiraclone.viewmodels.HomeViewModel

class HomeActivity : AppCompatActivity() {

    val activityViewModel : HomeViewModel by lazy { HomeViewModel() }

    override fun  onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
            supportFragmentManager.beginTransaction()
                .add(binding.frameId.id, DashboardFragment.newInstance())
                .commit()
    }
}