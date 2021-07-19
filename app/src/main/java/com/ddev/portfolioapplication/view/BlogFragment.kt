package com.ddev.portfolioapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.adapter.PopularBlogAdapter
import com.ddev.portfolioapplication.adapter.RecentBlogAdapter
import com.ddev.portfolioapplication.model.BlogData
import com.ddev.portfolioapplication.model.ProgressData
import kotlinx.android.synthetic.main.fragment_blog.*
import kotlinx.android.synthetic.main.fragment_skill_language.*


class BlogFragment : Fragment() {

    private val popularBlogAdapter by lazy { PopularBlogAdapter() }
    private val recentBlogAdapter by lazy { RecentBlogAdapter() }
    private val popularBlogList = ArrayList<BlogData>()
    private val blogList = ArrayList<BlogData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blog, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPopularRecyclerView()
        setUpRecentRecyclerView()
    }

    private fun setUpPopularRecyclerView() {
        popular_blog_recyclerview.layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.HORIZONTAL,
                false

        )
        popular_blog_recyclerview.setHasFixedSize(true)

        setUpBlogList()

        popular_blog_recyclerview.adapter = popularBlogAdapter
        popularBlogAdapter.setData(blogList)
    }

    private fun setUpRecentRecyclerView() {
        recent_blog_recyclerview.layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false

        )
        recent_blog_recyclerview.setHasFixedSize(true)

        setUpBlogList()

        recent_blog_recyclerview.adapter = recentBlogAdapter
        recentBlogAdapter.setData(blogList)
    }

    private fun setUpBlogList() {
        blogList.add(BlogData("Learn OOP and Database!","Learn OOP and Database!",R.drawable.blogimage
                ,"by Mark","read 10 times","20 min ago"
                ,"","OOP Concept"))

        blogList.add(BlogData("Learn OOP and Database!","Learn OOP and Database!",R.drawable.blogimage
                ,"by Mark","read 10 times","20 min ago"
                ,"","OOP Concept"))

        blogList.add(BlogData("Learn OOP and Database!","Learn OOP and Database!",R.drawable.blogimage
                ,"by Mark","read 10 times","20 min ago"
                ,"","OOP Concept"))

        blogList.add(BlogData("Learn OOP and Database!","Learn OOP and Database!",R.drawable.blogimage
                ,"by Mark","read 10 times","20 min ago"
                ,"","OOP Concept"))

        blogList.add(BlogData("Learn OOP and Database!","Learn OOP and Database!",R.drawable.blogimage
                ,"by Mark","read 10 times","20 min ago"
                ,"","OOP Concept"))
    }


}