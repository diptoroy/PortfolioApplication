package com.ddev.portfolioapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.portfolioapplication.adapter.MenuAdapter
import com.ddev.portfolioapplication.model.MenuData
import com.ddev.portfolioapplication.utils.OnClickListener
import com.ddev.portfolioapplication.R
import com.ddev.portfolioapplication.model.ProjectData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener {

    private val menuAdapter by lazy {
        MenuAdapter(
                this
        )
    }

    private var selectPosition: Int = 0
    private val menuList = ArrayList<MenuData>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpMenuRecyclerView()
        navController = findNavController(R.id.host_fragment)
    }

    private fun setUpMenuRecyclerView() {
        menu_recyclerview.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false

        )
        menu_recyclerview.setHasFixedSize(true)


        menuList.add(MenuData(R.drawable.ic_baseline_home_24, "Profile", true))
        menuList.add(MenuData(R.drawable.ic_baseline_work_24, "Career", false))
        menuList.add(MenuData(R.drawable.ic_baseline_bookmark_24, "Skill", false))
        menuList.add(MenuData(R.drawable.ic_baseline_keyboard_24, "Project", false))
        menuList.add(MenuData(R.drawable.ic_baseline_info_24, "Blog", false))

        menu_recyclerview.adapter = menuAdapter
        menuAdapter.setData(menuList)
    }

    override fun onMenuClick(item: MenuData, position: Int) {
        menuList[selectPosition].isSelected = false
        menuList[position].isSelected = true
        selectPosition = position
        menuAdapter.notifyDataSetChanged()
        when(position){
            0 -> navController.navigate(R.id.profileFragment)
            1 -> navController.navigate(R.id.careerFragment)
            2 -> navController.navigate(R.id.skillFragment)
            3 -> navController.navigate(R.id.projectFragment)
            4 -> navController.navigate(R.id.blogFragment)
        }
        Log.d("clicked","$position")
    }

    override fun onProjectClick(item: ProjectData, position: Int) {
        TODO("Not yet implemented")
    }
}