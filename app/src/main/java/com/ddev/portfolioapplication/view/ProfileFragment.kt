package com.ddev.portfolioapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.adapter.CareerAdapter
import com.ddev.portfolioapplication.adapter.SocialAdapter
import com.ddev.portfolioapplication.model.CareerData
import com.ddev.portfolioapplication.model.SocialData
import kotlinx.android.synthetic.main.fragment_work.*
import kotlinx.android.synthetic.main.profile_intro_layout.*

class ProfileFragment : Fragment() {

    private val socialAdapter by lazy { SocialAdapter() }
    private val socialList = ArrayList<SocialData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}