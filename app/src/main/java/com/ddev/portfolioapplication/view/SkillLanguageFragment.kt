package com.ddev.portfolioapplication.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.adapter.ProgressAdapter
import com.ddev.portfolioapplication.model.ProgressData
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import kotlinx.android.synthetic.main.fragment_skill.*
import kotlinx.android.synthetic.main.fragment_skill_language.*


class SkillLanguageFragment : Fragment() {

    private val progressAdapter by lazy { ProgressAdapter() }
    private val progressList = ArrayList<ProgressData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_skill_language, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpProgressRecyclerView()

    }

    private fun setUpProgressRecyclerView() {
        progress_recyclerview.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false

        )
        progress_recyclerview.setHasFixedSize(true)

        progressList.add(ProgressData("Java","80%",75))
        progressList.add(ProgressData("Kotlin","70%",70))
        progressList.add(ProgressData("C","50%",50))
        progressList.add(ProgressData("Python","20%",20))
        progressList.add(ProgressData("JavaScript","45%",45))

        progress_recyclerview.adapter = progressAdapter
        progressAdapter.setData(progressList)
    }


}