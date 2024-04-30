package com.example.codialappexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.codialappexample.R
import com.example.codialappexample.adapters.VpAdapter
import com.example.codialappexample.databinding.FragmentGroupHomeBinding
import com.example.codialappexample.models.Course
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GroupHomeFragment : Fragment() {

    private lateinit var binding: FragmentGroupHomeBinding
    private lateinit var adapter: VpAdapter

    private lateinit var course: Course

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        course = arguments?.getSerializable("course") as Course
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroupHomeBinding.inflate(layoutInflater, container, false)
        binding.toolBar.title = course.title

        adapter = VpAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 1) {
                    binding.toolBar.inflateMenu(R.menu.add)
                    binding.toolBar.setOnMenuItemClickListener {
                        findNavController().navigate(
                            R.id.addGroupFragment,
                            bundleOf("course" to course)
                        )
                        true
                    }
                } else {
                    binding.toolBar.menu.clear()
                }
            }
        })

        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab, position -> // Styling each tab here
            if (position == 0) {
                tab.text = "Ochilgan guruhlar"
            } else {
                tab.text = "Ochilayotgan guruhlar"
            }
        }.attach()

        return binding.root
    }
}