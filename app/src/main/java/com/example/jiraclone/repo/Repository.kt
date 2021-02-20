package com.example.jiraclone.repo

import com.example.jiraclone.models.*

object Repository {

    var teamsList : MutableList<Team> = mutableListOf()
    private var listOfTask : MutableList<Task> = mutableListOf()
    private var teamMemberListInDolphin : MutableList<TeamMember> = mutableListOf()
    private var teamMemberListinPeguin : MutableList<TeamMember> = mutableListOf()
    private var teamMembersInKayote : MutableList<TeamMember> = mutableListOf()
    private var allMembers : MutableSet<TeamMember> = mutableSetOf()
    private var allMembersName : MutableSet<String> = mutableSetOf()
    //Task(val name: String, val content: String, val assigned: Assigned, val status:Status, val team: String)
    //data class Assigned(val name: String, val contact: String, val mode: Mode)

//    data class ListOfTeam(var teamList: List<Team>? = null)
//
//    data class Team( var logo: String? = "", var name : String? = "", var listOfMembers: MutableList<TeamMember>? = null)
//
//    data class TeamMember (var firstName:  String? = "",
//                           var lastName : String? = "",
//                           var teamName: String? ="",
//                           var teamLead : Boolean? = false,
//                           var listOfTask: List<Task>? = null,
//                           var contact: String? ="",
//                           var mode: String? = null)
////"clovis", "1234", Mode("OffShore")
//
//    data class Task(var name: String="",
//                    var content: String? ="",
//                    var assigned: Assigned?= null,
//                    var status:Status? = Status.NOTSTARTED,
//                    var team: String ? = "",
//                    var taskId:Long)
//
//    data class Assigned(val name: String? = "", val contact: String? ="", val mode: MODE?= MODE.WORKSITE)
//
//    enum class Status {NOTSTARTED, PROGRESS, DONE, CONTROL, APPROVE}
//
//    enum class MODE {OFFSHORE, HOME, WORKSITE}

    init {
        listOfTask.add(Task("Create Login", "Login should contains two buttons", Assigned("clovis", "1234"),  team = "First", taskId = 0))
        listOfTask.add(Task("Create Work", "Work on Teams",Assigned("clovis", "1234"),  team = "First", taskId = 0))
        listOfTask.add(Task("Visit Honolulu", "Go To honolulu", Assigned("clovis", "1234"),  team = "First", taskId = 0))
        listOfTask.add(Task("Fly Abroad", "Fly by plane", Assigned("clovis", "1234"),  team = "First", taskId = 0))
        listOfTask.add(Task("Build", "Build a house", Assigned("clovis", "1234"),  team = "First", taskId = 0))
        listOfTask.add(Task("Amazon", "Do shopping", Assigned("clovis", "1234"),  team = "First", taskId = 0))
        listOfTask.add(Task("Car dealers", "Get A deal on Cars", Assigned("clovis", "1234"),  team = "First", taskId = 0))
        listOfTask.add(Task("Coach Team", "Talk to football players", Assigned("clovis", "1234"),  team = "First", taskId = 0))

        teamMemberListInDolphin.clear()
        teamMemberListInDolphin.add(TeamMember("Liam","Ethan", teamName = "Dolphin", teamLead = true, listOfTask = listOfTask))
        teamMemberListInDolphin.add(TeamMember("Soso","Milton", teamLead = false, teamName = "Dolphin", listOfTask = listOfTask))
        teamMemberListInDolphin.add(TeamMember("Clova","Inak","Dolphin", listOfTask = listOfTask))
        teamMemberListInDolphin.add(TeamMember("Marie","Jour","Dolphin", listOfTask = listOfTask))
        teamMemberListInDolphin.add(TeamMember("Mira","Abonge","Dolphin"))
        teamMemberListInDolphin.add(TeamMember("Milton","Ak","Dolphin"))

        teamMembersInKayote.clear()
        teamMembersInKayote.add(TeamMember("Liam","Ethan", teamName = "kayote", teamLead = true))
        teamMembersInKayote.add(TeamMember("SosoDrrtt","Milton", teamName = "kayote"))
        teamMembersInKayote.add(TeamMember("Clovadrg","Inak","kayote", listOfTask = listOfTask))
        teamMembersInKayote.add(TeamMember("MarieTou","Inaka","kayote", listOfTask = listOfTask))
        teamMembersInKayote.add(TeamMember("Miranak","Eliel","kayote", listOfTask = listOfTask))
        teamMembersInKayote.add(TeamMember("Miltondfj","Ak","kayote"))


        teamMemberListinPeguin.clear()
        teamMemberListinPeguin.add(TeamMember("LiamJolei","Ethan", teamName = "penguin", teamLead = true, listOfTask = listOfTask))
        teamMemberListinPeguin.add(TeamMember("SosoDrrtt","norbert", teamLead = false, teamName = "penguin"))
        teamMemberListinPeguin.add(TeamMember("Clovaiiiii","Inak","penguin", listOfTask = listOfTask))
        teamMemberListinPeguin.add(TeamMember("Mariejjjjj","Inaka","penguin",false, listOfTask = listOfTask))
        teamMemberListinPeguin.add(TeamMember("Mirajjjjj","Cold","penguin",false))
        teamMemberListinPeguin.add(TeamMember("Miltonjjjj","Ak","penguin",false))

        allMembers.clear()
        allMembers.addAll(teamMemberListInDolphin)
        allMembers.addAll(teamMembersInKayote)
        allMembers.addAll(teamMemberListinPeguin)

        teamsList.clear()
        teamsList.add(Team("0", "Dolphin",  teamMemberListInDolphin))
        teamsList.add(Team("1", "kayote", teamMembersInKayote))
        teamsList.add(Team("2", "penguin", teamMemberListinPeguin))
    }

    /**
     * Tasks
     */
    fun addTaskToLisOfTasks(task: Task):Boolean {
         listOfTask.forEach {
             if(it.name.contains(task.name, true)) {
                 return false
             }
         }

         listOfTask.add(task)

         return true
     }

    fun updateTask(task: Task): Boolean {
        listOfTask.forEach {
            if(it.taskId == task.taskId) {
                listOfTask.remove(it)
                listOfTask.add(task)
                return true
            }
        }

        return false
    }

    fun deleteTask(task: Task) {
        listOfTask.remove(task)
    }

    fun getListOfTask() = listOfTask

    fun getLastAvailableTaskId() : Int {
        return listOfTask.size
    }

    /**
     * Team members
     */
    fun addTeamMember(member: TeamMember): Boolean {
       teamsList.forEach {
           if(it.name.equals(member.teamName)) {
               it.listOfMembers?.forEach { mate->
                   if(mate.teamName.equals(member.teamName)) {
                       //no need to add this member if  he is already in the team.
                       return false
                   }
               }
               //we add him if the team exist and he is really supposed to be member of that team.
               if (it.listOfMembers != null) {
                   it.listOfMembers?.add(member)
               }else {
                   it.listOfMembers = mutableListOf()
                   it.listOfMembers?.add(member)
               }
               return true
           }
       }
        //if the team doesn't exist we can't add him because he needs to be member of an existing team.
        return false
    }

    fun removeMemberInATeam(member: TeamMember): Boolean {
        teamsList.forEach {
            if (it.name.equals(member.teamName)) {
                it.listOfMembers?.forEach { mate ->
                    if (mate.teamName.equals(member.teamName)) {
                        it.listOfMembers?.remove(mate)
                        return true
                    }
                }
            }
        }

        return false
    }

    /**
     * Teams
     */
    fun getTeams() : Set<Team> {
        val  singleEntryList : MutableSet<Team> = mutableSetOf()
        val  resultEntryList : MutableSet<String> = mutableSetOf()

        for (team in teamsList) {
            val  name = team.name + team.logo
            resultEntryList.add(name)
        }

        resultEntryList.forEach {names ->
            teamsList.filter { it.name?.let { it1 -> names.contains(it1) }== true
                    && it.logo?.let { it1 -> names.contains(it1) }== true}.also {
                if(!singleEntryList.contains(it[0])) {
                    singleEntryList.add(it[0])
                }
            }
        }

        return  singleEntryList
    }

    fun addTeam(team: Team) : Boolean {
        teamsList.forEach {
            if(it.name.equals(team.name)) {
                return false
            }
        }

        teamsList.add(team)

        return true
    }

    fun deleteTeam(team: Team) : Boolean {
        if(teamsList.contains(team)) {
            teamsList.remove(team)
            return  true
        }

        return false
    }

    /**
     * All members
     */
    fun getAllMembers() : Set<TeamMember> {
        val  singleEntryList : MutableSet<TeamMember> = mutableSetOf()
        val  resultEntryList : MutableSet<String> = mutableSetOf()

        for (allMember in allMembers) {
            val  name = allMember.firstName + allMember.lastName
            resultEntryList.add(name)
        }

        resultEntryList.forEach {names ->
            allMembers.filter { it.firstName?.let { it1 -> names.contains(it1) }== true
                    && it.lastName?.let { it1 -> names.contains(it1) }== true }.also {
                if(!singleEntryList.contains(it[0])) {
                    singleEntryList.add(it[0])
                }
            }
        }

        return  singleEntryList
    }

    fun getAllMembersWithTeam(teamName: String) : Set<TeamMember> {
        return getAllMembers().filter { it.teamName.equals(teamName) }.toSet()
    }
}