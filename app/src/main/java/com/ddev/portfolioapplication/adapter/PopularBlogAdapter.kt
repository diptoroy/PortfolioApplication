package com.ddev.portfolioapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.model.BlogData
import kotlinx.android.synthetic.main.popular_blog_row.view.*
import kotlinx.android.synthetic.main.recent_blog_row.view.*
import kotlinx.android.synthetic.main.recent_blog_row.view.recent_main_image

class PopularBlogAdapter : RecyclerView.Adapter<PopularBlogAdapter.ViewHolder>() {
    private var popularBlogList = emptyList<BlogData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_blog_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.popular_main_title.text = popularBlogList[position].blogTitle.toString()
        Glide.with(holder.itemView.context).load(popularBlogList[position].blogImage).into(holder.itemView.popular_main_image)
        holder.itemView.popular_main_read_count.text = popularBlogList[position].blogReadCount.toString()
        holder.itemView.popular_main_time.text = popularBlogList[position].blogTime.toString()

//        holder.itemView.setOnClickListener{
//            val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
//            intent.putExtra("title",[position].title)
//            intent.putExtra("director",[position].director)
//            holder.itemView.context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return popularBlogList.size
    }

    fun setData(newList: List<BlogData>){
        notifyDataSetChanged()
        popularBlogList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}