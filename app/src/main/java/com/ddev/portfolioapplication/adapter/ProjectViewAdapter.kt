package com.ddev.portfolioapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.model.ProjectSectionData
import kotlinx.android.synthetic.main.projectview_row.view.*

class ProjectViewAdapter : RecyclerView.Adapter<ProjectViewAdapter.ViewHolder>() {
    private var projectSectionList = emptyList<ProjectSectionData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.projectview_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.projectview_title.text = projectSectionList[position].projectName.toString()
        Glide.with(holder.itemView.context).load(projectSectionList[position].projectImage).into(holder.itemView.projectview_image)

//        holder.itemView.setOnClickListener{
//            val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
//            intent.putExtra("title",[position].title)
//            intent.putExtra("director",[position].director)
//            holder.itemView.context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return projectSectionList.size
    }

    fun setData(newList: List<ProjectSectionData>){
        notifyDataSetChanged()
        projectSectionList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}