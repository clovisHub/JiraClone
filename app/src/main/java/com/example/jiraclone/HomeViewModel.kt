package com.example.jiraclone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jiraclone.models.Task
import com.example.jiraclone.repo.Repository

class HomeViewModel: ViewModel() {

    private val liveTaskList: MutableLiveData<List<Task>> = MutableLiveData()

    init {
        liveTaskList.value = Repository.listOfTask
    }

    fun getListOfTask() : LiveData<List<Task>> = liveTaskList
}