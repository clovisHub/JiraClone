package com.example.jiraclone.ui.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jiraclone.databinding.TeamItemBinding
import com.example.jiraclone.models.Teams

class TeamListAdapter (private var teamsListener: TeamsListListener): RecyclerView.Adapter<TeamListAdapter.TeamsHolder>() {

    private var teamList: MutableList<Teams> = mutableListOf()

    fun setTeamList(teams: List<Teams>) {
        teamList.clear()
        teamList.addAll(teams)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsHolder {
        val view = TeamItemBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)

        return TeamsHolder(view)
    }

    override fun onBindViewHolder(teamsHolder: TeamsHolder, position: Int) {
        teamsHolder.view.teams = teamList[position]
        teamsHolder.view.root.setOnClickListener{
            teamsListener.onClick(teamList[position])
        }
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    class TeamsHolder(val view: TeamItemBinding) : RecyclerView.ViewHolder(view.root)

    interface TeamsListListener {
        fun  onClick(teams: Teams)
    }

}