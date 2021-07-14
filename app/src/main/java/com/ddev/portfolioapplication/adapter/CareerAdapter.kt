package com.ddev.portfolioapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.model.CareerData
import kotlinx.android.synthetic.main.career_row.view.*

class CareerAdapter : RecyclerView.Adapter<CareerAdapter.ViewHolder>() {
    private var careerList = emptyList<CareerData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.career_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.career_position_text.text = careerList[position].careerPosition.toString()
        holder.itemView.career_company_text.text = careerList[position].careerCompany.toString()
        holder.itemView.career_duration_text.text = careerList[position].careerDuration.toString()

//        com.bumptech.glide.Glide.with(holder.itemView.context).load([position].actorDetails?.get(position)?.actorImage).into(holder.itemView.actorImage)
//
//        holder.itemView.setOnClickListener{
//            val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
//            intent.putExtra("title",[position].title)
//            intent.putExtra("director",[position].director)
//            holder.itemView.context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return careerList.size
    }

    fun setData(newList: List<CareerData>){
        notifyDataSetChanged()
        careerList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}