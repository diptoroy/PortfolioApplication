package com.ddev.portfolioapplication.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.adapter.CareerAdapter
import com.ddev.portfolioapplication.adapter.ProjectAdapter
import com.ddev.portfolioapplication.adapter.SkillFragmentAdapter
import com.ddev.portfolioapplication.model.CareerData
import com.ddev.portfolioapplication.model.MenuData
import com.ddev.portfolioapplication.model.ProjectData
import com.ddev.portfolioapplication.model.ProjectSectionData
import com.ddev.portfolioapplication.utils.OnClickListener
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_project.*
import kotlinx.android.synthetic.main.fragment_skill.view.*
import kotlinx.android.synthetic.main.fragment_work.*

class ProjectFragment : Fragment(),OnClickListener {

    private val projectAdapter by lazy { ProjectAdapter(this) }
    private val projectList = ArrayList<ProjectData>()
    private val projectSectionList1 = ArrayList<ProjectSectionData>()
    private val projectSectionList2 = ArrayList<ProjectSectionData>()
    private val projectSectionList3 = ArrayList<ProjectSectionData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_project, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        project_recyclerview.layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.HORIZONTAL,
                false

        )
        project_recyclerview.setHasFixedSize(true)

        projectSectionList1.add(ProjectSectionData("Web App",R.drawable.github))
        projectSectionList1.add(ProjectSectionData("Web App",R.drawable.github))
        projectSectionList1.add(ProjectSectionData("Web App",R.drawable.github))

        projectSectionList2.add(ProjectSectionData("Android App",R.drawable.linkedin))
        projectSectionList2.add(ProjectSectionData("Android App",R.drawable.linkedin))
        projectSectionList2.add(ProjectSectionData("Android App",R.drawable.linkedin))

        projectSectionList3.add(ProjectSectionData("UI App",R.drawable.twitter))
        projectSectionList3.add(ProjectSectionData("UI App",R.drawable.twitter))

        projectList.add(ProjectData("All",projectSectionList1))
        projectList.add(ProjectData("Web Design",projectSectionList1))
        projectList.add(ProjectData("Android",projectSectionList2))
        projectList.add(ProjectData("UI",projectSectionList3))

        project_recyclerview.adapter = projectAdapter
        projectAdapter.setData(projectList)
    }

    override fun onMenuClick(item: MenuData, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onProjectClick(item: ProjectData, position: Int) {
        Toast.makeText(activity, "$position", Toast.LENGTH_SHORT).show()
        Log.d("Clicked :","$item")

//        val intent = Intent(this, NextActivity::class.java)
//        intent.putExtra("list", ArrayList(item.customer))
//        startActivity(intent)
    }

}