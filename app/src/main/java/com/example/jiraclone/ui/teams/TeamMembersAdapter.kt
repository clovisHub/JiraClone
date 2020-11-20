package com.example.jiraclone.ui.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jiraclone.databinding.SingleMemberItemBinding
import com.example.jiraclone.models.TeamMember

class TeamMembersAdapter(private var teamMemberListener: TeamMemberListener) : RecyclerView.Adapter<TeamMembersAdapter.TeamMemberHolder>() {

    private var teamMemberList : MutableList<TeamMember> = mutableListOf()

    fun setTeamMemberList(teamMember: List<TeamMember>){
        teamMemberList.clear()
        teamMemberList.addAll(teamMember)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberHolder {
        val view = SingleMemberItemBinding.inflate(LayoutInflater.from(parent.context),
        parent, false)

        return TeamMemberHolder(view)
    }

    override fun onBindViewHolder(teamsMemberHolder: TeamMemberHolder, position: Int) {
        teamsMemberHolder.view.teamMember = teamMemberList[position]
        teamsMemberHolder.view.root.setOnClickListener{
            teamMemberListener.onClick(teamMemberList[position])
        }
    }

    override fun getItemCount(): Int {
        return teamMemberList.size
    }

    class TeamMemberHolder (val view: SingleMemberItemBinding) : RecyclerView.ViewHolder(view.root)
    interface  TeamMemberListener{
        fun onClick(teamMember: TeamMember)
    }
}