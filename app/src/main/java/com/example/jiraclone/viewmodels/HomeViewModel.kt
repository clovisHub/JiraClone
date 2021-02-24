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

    private val liveAllMember : MutableLiveData<Set<TeamMember>> = MutableLiveData()

    private val liveTeamsList: MutableLiveData<List<Team>> = MutableLiveData()
    private val liveTeamsMemberList: MutableLiveData<Event<List<TeamMember>>> = MutableLiveData()
    private val liveTeamMemberEvent : MutableLiveData<Event<TeamMember>> = MutableLiveData()

    private val liveTeamEvent : MutableLiveData<Event<Team>> = MutableLiveData()
    private val liveTeamName : MutableLiveData<String> = MutableLiveData()
    private val liveMemberName : MutableLiveData<String> = MutableLiveData()

    //Tasks
    private val liveTaskList: MutableLiveData<List<Task>> = MutableLiveData()
    private val liveTaskEvent : MutableLiveData<Event<Task?>> = MutableLiveData()
    private val liveUpdateTaskEvent : MutableLiveData<Event<Task>> = MutableLiveData()

    private val liveDataState : MutableLiveData<Int> = MutableLiveData()

    init {
        liveTaskList.value = Repository.getListOfTask()
       // Log.d("numbers", Repository.listOfTask.size.toString())
        liveTeamsList.value = Repository.teamsList
        liveAllMember.value = Repository.getAllMembers()
        liveDataState.value = 0
    }

    fun getListOfTask() : LiveData<List<Task>> = liveTaskList

    fun refreshListOfTask() {
        liveTaskList.value = Repository.getListOfTask()
    }

    fun getTeamsList() : LiveData<List<Team>> = liveTeamsList

    fun getTeamMemberList(teamName: String ="") : LiveData<Event<List<TeamMember>>> {
        liveTeamsMemberList.value = Event(Repository
            .getAllMembersWithTeam(liveTeamName.value?:teamName).toList())

        return liveTeamsMemberList
    }

    fun setCurrentTeamMembersList(teamName: String ="") {
        liveTeamsMemberList.value = Event(Repository.getAllMembersWithTeam(teamName).toList())
    }

    fun setCurrentTeamMemberName(memberName: String ="") {
        liveMemberName.value = memberName
    }

    fun getCurrentTeamMemberName() = liveMemberName.value


    //from TasksList page
    fun setCurrentTeam(team: Team) {
        liveTeamEvent.value = Event(team)
    }

    fun setCurrentTeamName(teamName: String) {
        liveTeamName.value = teamName
    }

    fun getCurrentTeamName() = liveTeamName.value

    fun setCurrentTeamMember(teamMember: TeamMember){
        liveTeamMemberEvent.value = Event(teamMember)
    }

    fun createTask() {
        when(liveDataState.value) {
            1 ->  liveTaskEvent.value = Event(Task(taskId = Repository
                .getLastAvailableTaskId().toLong()))

            2 -> liveUpdateTaskEvent.value = Event(Task(taskId = Repository
                .getLastAvailableTaskId().toLong()))
        }
    }

    fun createTeam(){
        liveTeamEvent.value = Event(Team("", ""))
    }

    fun createTeamMember(){
        liveTeamMemberEvent.value = Event(TeamMember("", ""))
    }

    fun observeCurrentTaskEvent() : LiveData<Event<Task?>> = liveTaskEvent

    fun observeCurrentUpdateTaskEvent() : LiveData<Event<Task>> = liveUpdateTaskEvent

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

    //View State

    fun setViewState(state:Int) {
        liveDataState.value = state
    }

    fun setCurrentTask(task: Task?) {
        liveTaskEvent.value = if(task?.taskId != null) Event(task) else Event(Task( ))
    }

    fun getCurrentTaskId(): LiveData<Event<Task?>> = liveTaskEvent

    //All Members
    fun getAllMemberList() : LiveData<Set<TeamMember>> = liveAllMember

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