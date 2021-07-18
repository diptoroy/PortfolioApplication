package com.ddev.portfolioapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ddev.portfolioapplication.adapter.ProjectViewAdapter
import com.ddev.portfolioapplication.model.ProjectSectionData
import kotlinx.android.synthetic.main.fragment_all_project.*
import kotlinx.android.synthetic.main.fragment_project.*


class AllProjectFragment : Fragment() {

    private val projectViewAdapter by lazy { ProjectViewAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_project, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bundle: Bundle = this.requireArguments()
        var list = bundle.getParcelableArrayList<ProjectSectionData>("list") as ArrayList<ProjectSectionData>
        Log.d("intent","$bundle")

        project_view_recyclerview.layoutManager = StaggeredGridLayoutManager(
            4,LinearLayoutManager.VERTICAL
        )
        project_view_recyclerview.setHasFixedSize(true)

        project_view_recyclerview.adapter = projectViewAdapter
        projectViewAdapter.setData(list)
        projectViewAdapter.notifyDataSetChanged()
    }

}