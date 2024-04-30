package com.example.codialappexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.codialappexample.R
import com.example.codialappexample.databinding.FragmentAddStudentBinding
import com.example.codialappexample.db.CodialDatabase
import com.example.codialappexample.models.Group
import com.example.codialappexample.models.Student

class AddStudentFragment : Fragment() {

    private lateinit var binding: FragmentAddStudentBinding
    private lateinit var codialDatabase: CodialDatabase
    private var groupId: Int? = null
    private lateinit var group: Group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        codialDatabase = CodialDatabase(requireContext())
        groupId = arguments?.getInt("groupId")
        group = codialDatabase.getGroupById(groupId!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddStudentBinding.inflate(layoutInflater, container, false)

        binding.save.setOnClickListener {
            val name: String = binding.name.text.toString()
            val surname: String = binding.surname.text.toString()
            val fatherName: String = binding.fatherName.text.toString()

            codialDatabase.addStudent(Student(name, surname, fatherName, group))
            findNavController().popBackStack()
        }

        return binding.root
    }
}