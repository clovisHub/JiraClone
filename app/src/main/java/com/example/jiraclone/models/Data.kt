package com.example.jiraclone.models


data class ListOfTeam(var teamList: List<Team>? = null)

data class Team( var logo: String? = "",
                 var name : String? = "",
                 var listOfMembers: MutableList<TeamMember>? = null)

data class TeamMember (var firstName:  String? = "",
                       var lastName : String? = "",
                       var teamName: String? ="",
                       var teamLead : Boolean? = false,
                       var listOfTask: List<Task>? = null,
                       var contact: String? ="",
                       var mode: String? = null)
//"clovis", "1234", Mode("OffShore")

data class Task(var name: String="",
                var content: String? ="",
                var assigned: Assigned?= null,
                var status:Status? = Status.NOTSTARTED,
                var team: String ? = "",
                var taskId:Long,
                var dateCreated: String="",
                var dateStarted: String="",
                var dateCompleted: String="",
                var expectedTime: String ="")

data class Assigned(val name: String? = "", val contact: String? ="", val mode: MODE?= MODE.WORKSITE)

enum class Status {NOTSTARTED, PROGRESS, DONE, CONTROL, APPROVE}

enum class MODE {OFFSHORE, HOME, WORKSITE}
