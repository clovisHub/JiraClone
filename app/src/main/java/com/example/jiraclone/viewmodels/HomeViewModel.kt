package com.example.jiraclone.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jiraclone.models.Task
import com.example.jiraclone.models.Teams
import com.example.jiraclone.repo.Repository

class HomeViewModel: ViewModel() {

    private val liveTaskList: MutableLiveData<List<Task>> = MutableLiveData()
    private val liveTeamsList: MutableLiveData<List<Teams>> = MutableLiveData()

    init {
        liveTaskList.value = Repository.listOfTask
        liveTeamsList.value = Repository.teamsList
    }

    fun getListOfTask() : LiveData<List<Task>> = liveTaskList
    fun getTeamsList() : LiveData<List<Teams>> = liveTeamsList
}