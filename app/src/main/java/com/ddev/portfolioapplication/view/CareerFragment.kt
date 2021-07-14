package com.ddev.portfolioapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.adapter.CareerFragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_career.view.*


class CareerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_career, container, false)
        var careerAdapter = CareerFragmentAdapter(childFragmentManager,lifecycle)
        view.viewPager.adapter = careerAdapter
        TabLayoutMediator(view.tabLayout,view.viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position){
                    0 -> {
                        tab.text = "Work"
                    }
                    1 -> {
                        tab.text = "Education"
                    }
                }
            }).attach()
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}