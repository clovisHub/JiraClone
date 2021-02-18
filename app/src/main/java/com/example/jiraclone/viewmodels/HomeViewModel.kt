package com.example.jiraclone

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jiraclone.models.Task
import com.example.jiraclone.models.Team
import com.example.jiraclone.models.TeamMember
import com.example.jiraclone.repo.Repository

class HomeViewModel: ViewModel() {

    private val liveTaskList: MutableLiveData<List<Task>> = MutableLiveData()
    private val liveTeamsList: MutableLiveData<List<Team>> = MutableLiveData()
    private val liveTeamsMemberList: MutableLiveData<List<TeamMember>> = MutableLiveData()
    private val liveTaskEvent : MutableLiveData<Event<Task>> = MutableLiveData()
    private val liveTeamEvent : MutableLiveData<Event<Team>> = MutableLiveData()
    private val liveTeamMemberEvent : MutableLiveData<Event<TeamMember>> = MutableLiveData()

    init {
        //liveTaskList.value = Repository
       // Log.d("numbers", Repository.listOfTask.size.toString())
        liveTeamsList.value = Repository.teamsList
        //liveTeamsMemberList.value = Repository.teamMemberList
    }

    fun getListOfTask() : LiveData<List<Task>> = liveTaskList
    fun getTeamsList() : LiveData<List<Team>> = liveTeamsList
    fun getTeamMemberList() : LiveData<List<TeamMember>> = liveTeamsMemberList

    fun setCurrentTask(task: Task) {
        liveTaskEvent.value = Event(task)
    }

    fun setCurrenntTeam(teams: Team){
        liveTeamEvent.value = Event(teams)
    }

    fun setCurrentTeamMember(teamMember: TeamMember){
        liveTeamMemberEvent.value = Event(teamMember)
    }

    fun createTask() {
        liveTaskEvent.value = Event(Task(taskId = Repository.getLastAvailableTaskId().toLong()))
    }

    fun createTeam(){
        liveTeamEvent.value = Event(Team("", ""))
    }

    fun createTeamMember(){
        liveTeamMemberEvent.value = Event(TeamMember("", ""))
    }

    fun observeCurrentTaskEvent() : LiveData<Event<Task>> = liveTaskEvent
    fun observeCurrentTeamEvent() : LiveData<Event<Team>> = liveTeamEvent
    fun observeCurrentTeamMemberEvent() : LiveData<Event<TeamMember>> = liveTeamMemberEvent

    fun setItemEntry(item: Any) {
        if(Repository.teamsList.contains(item)) {
            liveTeamEvent.value = Event(item as Team)
        }
    }

    fun onSelectItem(parent: AdapterView<*>, view: View, pos: Int, id: Long) {

    }

    fun addTask(task: Task) {
        Repository.addTaskToLisOfTasks(task)
        //Log.d("numbers", Repository.listOfTask.size.toString())
    }

//    fun addNewTeam(teams: Team) {
//        Repository.teamsList.add(teams)
//        Log.d("numbers", Repository.teamsList.size.toString())
//    }
//
//    fun addNewTeamMember(teamMember: TeamMember) {
//        Repository.teamMemberList.add(teamMember)
//        Log.d("numbers", Repository.teamMemberList.size.toString())
//    }
}