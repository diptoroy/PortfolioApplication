package com.ddev.portfolioapplication.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.adapter.CareerFragmentAdapter
import com.ddev.portfolioapplication.adapter.ProgressAdapter
import com.ddev.portfolioapplication.adapter.SkillFragmentAdapter
import com.ddev.portfolioapplication.model.ProgressData
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_career.view.*
import kotlinx.android.synthetic.main.fragment_skill.*
import kotlinx.android.synthetic.main.fragment_skill.view.*

class SkillFragment : Fragment() {

    private var dataList = ArrayList<PieEntry>()
    private var labelList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_skill, container, false)
        var skillAdapter = SkillFragmentAdapter(childFragmentManager,lifecycle)
        view.viewPager2.adapter = skillAdapter
        TabLayoutMediator(view.tabLayout2,view.viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position){
                    0 -> {
                        tab.text = "Language"
                    }
                    1 -> {
                        tab.text = "Tool"
                    }
                }
            }).attach()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //MP Android Chart
        var colorList = arrayListOf<Int>(Color.BLUE, Color.MAGENTA, Color.CYAN)

        labelList.add("Android")
        labelList.add("Web Design")
        labelList.add("UI Design")

        dataList.add(PieEntry(50.0f, "Android"))
        dataList.add(PieEntry(30.0f, "Web Design"))
        dataList.add(PieEntry(20.0f, "UI Design"))

        val dataSet = PieDataSet(dataList,"")
        dataSet.colors = colorList
        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.invalidate()
        data.setValueTextSize(15f)
        data.setValueFormatter(PercentFormatter(pieChart))
        data.setValueTextColor(Color.WHITE)
        data.isHighlightEnabled = true

        initPieChart()
    }

    private fun initPieChart() {
        pieChart.setUsePercentValues(false)
        pieChart.description.text = ""
//        //hollow pie chart
        pieChart.isDrawHoleEnabled = false
        //pieChart.setTouchEnabled(false)
        pieChart.setDrawEntryLabels(true)
        pieChart.animateXY(1400, 1200)

        //adding padding
        pieChart.setExtraOffsets(20f, 0f, 20f, 20f)
        pieChart.setUsePercentValues(true)
        pieChart.isRotationEnabled = false
        pieChart.setDrawEntryLabels(false)
        pieChart.legend.orientation = Legend.LegendOrientation.HORIZONTAL
        pieChart.legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        pieChart.legend.textColor = Color.WHITE
        pieChart.legend.isWordWrapEnabled = true

    }


}