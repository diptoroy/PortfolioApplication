package com.ddev.portfolioapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.portfolioapplication.model.MenuData
import com.ddev.portfolioapplication.utils.OnClickListener
import com.ddev.portfolioapplication.R
import kotlinx.android.synthetic.main.menu_layout.view.*

class MenuAdapter(var onClickListener: OnClickListener) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    private var menuList = emptyList<MenuData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemAnim = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.fade_in)

        holder.itemView.menu_name.text = menuList[position].name.toString()
        Glide.with(holder.itemView.context).load(menuList[position].image).into(holder.itemView.menu_image)

        holder.itemView.setOnClickListener{
            onClickListener.onMenuClick(menuList[position], position)
        }

        if (menuList[position].isSelected){
            holder.itemView.setBackgroundResource(R.drawable.menu)
            holder.itemView.menu_name.visibility = View.VISIBLE
            holder.itemView.menu_image.animation = itemAnim
            holder.itemView.menu_name.animation = itemAnim
        }else{
            holder.itemView.setBackgroundResource(R.color.white)
            holder.itemView.menu_name.visibility = View.INVISIBLE
        }

    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun setData(newList: List<MenuData>){
        notifyDataSetChanged()
        menuList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}