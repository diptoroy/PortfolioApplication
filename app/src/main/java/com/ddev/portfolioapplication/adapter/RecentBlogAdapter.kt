package com.ddev.portfolioapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.model.BlogData
import kotlinx.android.synthetic.main.recent_blog_row.view.*

class RecentBlogAdapter : RecyclerView.Adapter<RecentBlogAdapter.ViewHolder>() {
    private var recentBlogList = emptyList<BlogData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recent_blog_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.recent_main_title.text = recentBlogList[position].blogTitle.toString()
        Glide.with(holder.itemView.context).load(recentBlogList[position].blogImage).into(holder.itemView.recent_main_image)
        holder.itemView.recent_main_category.text = recentBlogList[position].blogCategory.toString()
        holder.itemView.recent_main_author.text = recentBlogList[position].blogAuthor.toString()
        holder.itemView.recent_main_time.text = recentBlogList[position].blogTime.toString()

//
//        holder.itemView.setOnClickListener{
//            val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
//            intent.putExtra("title",[position].title)
//            intent.putExtra("director",[position].director)
//            holder.itemView.context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return recentBlogList.size
    }

    fun setData(newList: List<BlogData>){
        notifyDataSetChanged()
        recentBlogList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}