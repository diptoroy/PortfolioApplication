package com.ddev.portfolioapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.model.ProgressData
import kotlinx.android.synthetic.main.progress_bar_row.view.*

class ProgressAdapter : RecyclerView.Adapter<ProgressAdapter.ViewHolder>() {
    private var progressList = emptyList<ProgressData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.progress_bar_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.skill_name.text = progressList[position].skillName.toString()
        holder.itemView.skill_progress_text.text = progressList[position].skillProgressText
        holder.itemView.skill_progress.progress = progressList[position].skillProgress

//
//        holder.itemView.setOnClickListener{
//            val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
//            intent.putExtra("title",[position].title)
//            intent.putExtra("director",[position].director)
//            holder.itemView.context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return progressList.size
    }

    fun setData(newList: List<ProgressData>){
        notifyDataSetChanged()
        progressList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}