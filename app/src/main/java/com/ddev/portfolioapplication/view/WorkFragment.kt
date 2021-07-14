package com.ddev.portfolioapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.adapter.CareerAdapter
import com.ddev.portfolioapplication.model.CareerData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : Fragment() {

    private val careerAdapter by lazy { CareerAdapter() }
    private val careerList = ArrayList<CareerData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_work, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        work_recyclerview.layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false

        )
        work_recyclerview.setHasFixedSize(true)


        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))
        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))
        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))
        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))
        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))
        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))
        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))
        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))
        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))
        careerList.add(CareerData("Android Developer","Adornment Campus","Feb 2021 - Present"))

        work_recyclerview.adapter = careerAdapter
        careerAdapter.setData(careerList)
    }

}