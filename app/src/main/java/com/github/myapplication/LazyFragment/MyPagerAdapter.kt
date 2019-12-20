package com.github.myapplication.LazyFragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import java.util.ArrayList

class MyPagerAdapter(fm: FragmentManager, private var list: List<Fragment>) :FragmentPagerAdapter(fm){



    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return if (list == null){ 0 }else{list.size} 
    }


}