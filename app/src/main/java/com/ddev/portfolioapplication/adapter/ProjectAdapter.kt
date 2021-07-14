package com.ddev.portfolioapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.model.ProjectData
import com.ddev.portfolioapplication.utils.OnClickListener
import kotlinx.android.synthetic.main.project_row.view.*

class ProjectAdapter(private val onProjectClickListener: OnClickListener) : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {
    private var projectList = emptyList<ProjectData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.project_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.project_text.text = projectList[position].pName.toString()
//        com.bumptech.glide.Glide.with(holder.itemView.context).load([position].poster).into(holder.itemView.moviePoster)
//        holder.itemView.acotrName.text = [position].actorDetails?.get(position)?.actorName
//        com.bumptech.glide.Glide.with(holder.itemView.context).load([position].actorDetails?.get(position)?.actorImage).into(holder.itemView.actorImage)
//
        holder.itemView.setOnClickListener{
            onProjectClickListener.onProjectClick(projectList[position],position)
        }

    }

    override fun getItemCount(): Int {
        return projectList.size
    }

    fun setData(newList: List<ProjectData>){
        notifyDataSetChanged()
        projectList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}