package com.example.codialappexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codialappexample.databinding.FragmentCourseInfoBinding
import com.example.codialappexample.models.Course


class CourseInfoFragment : Fragment() {

    private lateinit var binding: FragmentCourseInfoBinding
    private lateinit var course: Course
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        course = arguments?.getSerializable("course") as Course
    }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
        ): View? {
            binding = FragmentCourseInfoBinding.inflate(layoutInflater, container, false)
            binding.toolBar.title = course.title
            binding.desc.text = course.desc
            return binding.root



    }
}