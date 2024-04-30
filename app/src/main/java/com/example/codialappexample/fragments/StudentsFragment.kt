package com.example.codialappexample.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.codialappexample.R
import com.example.codialappexample.adapters.StudentRvAdapter
import com.example.codialappexample.databinding.FragmentStudentsBinding
import com.example.codialappexample.db.CodialDatabase
import com.example.codialappexample.models.Group
import com.example.codialappexample.models.Student

class StudentsFragment : Fragment() {

    private lateinit var binding: FragmentStudentsBinding
    private lateinit var group: Group
    private var groupId: Int? = null
    private var groupTitle: String? = null
    private var groupTime: String? = null

    private lateinit var codialDatabase: CodialDatabase
    private lateinit var adapter: StudentRvAdapter
    private lateinit var studentsList: ArrayList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        codialDatabase = CodialDatabase(requireContext())

        groupId = arguments?.getInt("groupId")
        groupTitle = arguments?.getString("groupTitle")
        groupTime = arguments?.getString("groupTime")
        group = codialDatabase.getGroupById(groupId!!)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentsBinding.inflate(layoutInflater, container, false)
        binding.toolBar.title = groupTitle
        binding.toolBar.setOnMenuItemClickListener {
            findNavController().navigate(R.id.addStudentFragment, bundleOf("groupId" to groupId))
            true
        }
        studentsList = codialDatabase.getAllStudentsList()

        val studentList: ArrayList<Student> = ArrayList()
        for (i in 0 until studentsList.size) {
            if (studentsList[i].groupId?.id == groupId) {
                studentList.add(studentsList[i])
            }
        }

        binding.groupTitle.text = groupTitle
        binding.groupDesc.text = "O'quvchilar soni: ${studentList.size}"
        binding.groupTime.text = groupTime

        adapter = StudentRvAdapter(object : StudentRvAdapter.OnItemClick {
            override fun onItemClick(student: Student, position: Int) {

            }

            override fun onItemEditClick(student: Student, position: Int) {

            }

            override fun onItemDeleteClick(student: Student, position: Int) {

            }
        }, studentList)
        binding.recyclerView.adapter = adapter

        if (group.groupPosition == 0) {
            binding.startLesson.visibility = View.GONE
        }

        binding.startLesson.setOnClickListener {
            binding.startLesson.visibility = View.GONE
            group.groupPosition = 0

            codialDatabase.editGroup(group)
        }

        return binding.root
    }
}