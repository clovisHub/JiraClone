package com.example.jiraclone.repo

import com.example.jiraclone.models.*

object Repository {

    var teamsList : MutableList<Team> = mutableListOf()
    private var listOfTask : MutableList<Task> = mutableListOf()
    private var teamMemberListInDolphin : MutableList<TeamMember> = mutableListOf()
    private var teamMemberListinPeguin : MutableList<TeamMember> = mutableListOf()
    private var teamMembersInKayote : MutableList<TeamMember> = mutableListOf()
    //Task(val name: String, val content: String, val assigned: Assigned, val status:Status, val team: String)
    //data class Assigned(val name: String, val contact: String, val mode: Mode)

    init {
        listOfTask.add(Task("Create Login", "Login should contains two buttons",Assigned("clovis", "1234", Mode("OffShore")), Status("Not Started"), "First", 0))
        listOfTask.add(Task("Create Work", "Work on Teams",Assigned("Milton", "1234", Mode("In Office")), Status("Started"), "First", 1))
        listOfTask.add(Task("Visit Honolulu", "Go To honolulu",Assigned("John", "1234", Mode("Vacation")), Status("Not Started"), "second", 2))
        listOfTask.add(Task("Fly Abroad", "Fly by plane",Assigned("Maurice", "1234", Mode("Travelling")), Status("Not Started"), "First", 3))
        listOfTask.add(Task("Build", "Build a house",Assigned("Allen", "1234", Mode("Construction")), Status("Not Started"), "Third", 4))
        listOfTask.add(Task("Amazon", "Do shopping",Assigned("Marie", "1234", Mode("Buying")), Status("Not Started"), "First", 5))
        listOfTask.add(Task("Car dealers", "Get A deal on Cars",Assigned("Soso", "1234", Mode("Negotiation")), Status("Not Started"), "First", 6))
        listOfTask.add(Task("Coach Team", "Talk to football players",Assigned("Little Lea", "1234", Mode("Meetings")), Status("Not Started"), "First", 7))



//        teamsList.add(Team("3", "panda"))
//        teamsList.add(Team("4", "panther"))
//        teamsList.add(Team("5", "wolf"))
//        teamsList.add(Team("6", "gazel"))
//        teamsList.add(Team("7", "ram"))
//        teamsList.add(Team("8", "mouse"))
//        teamsList.add(Team("9", "fox"))

        teamMemberListInDolphin.add(TeamMember("Liam","Ethan", teamName = "Dolphin", teamLead = true, listOfTask = listOfTask))
        teamMemberListInDolphin.add(TeamMember("Soso","Milton", teamLead = false, teamName = "Dolphin", listOfTask = listOfTask))
        teamMemberListInDolphin.add(TeamMember("Clova","Inak","Dolphin", listOfTask = listOfTask))
        teamMemberListInDolphin.add(TeamMember("Marie","Inaka","Dolphin", listOfTask = listOfTask))
        teamMemberListInDolphin.add(TeamMember("Mira","Abonge","Dolphin"))
        teamMemberListInDolphin.add(TeamMember("Milton","Ak","Dolphin"))

        teamMembersInKayote.add(TeamMember("Liam","Ethan", teamName = "kayote", teamLead = true))
        teamMembersInKayote.add(TeamMember("Mol","Milton", teamName = "kayote"))
        teamMembersInKayote.add(TeamMember("Clovadrg","Inak","kayote", listOfTask = listOfTask))
        teamMembersInKayote.add(TeamMember("MarieTou","Inaka","kayote", listOfTask = listOfTask))
        teamMembersInKayote.add(TeamMember("Miranak","Abonge","kayote", listOfTask = listOfTask))
        teamMembersInKayote.add(TeamMember("Miltondfj","Ak","kayote"))

        teamMemberListinPeguin.add(TeamMember("LiamJolei","Ethan", teamName = "penguin", teamLead = true, listOfTask = listOfTask))
        teamMemberListinPeguin.add(TeamMember("SosoDrrtt","Milton", teamLead = false, teamName = "penguin"))
        teamMemberListinPeguin.add(TeamMember("Clovaiiiii","Inak","penguin", listOfTask = listOfTask))
        teamMemberListinPeguin.add(TeamMember("Mariejjjjj","Inaka","penguin",false, listOfTask = listOfTask))
        teamMemberListinPeguin.add(TeamMember("Mirajjjjj","Abonge","penguin",false))
        teamMemberListinPeguin.add(TeamMember("Miltonjjjj","Ak","penguin",false))

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
}