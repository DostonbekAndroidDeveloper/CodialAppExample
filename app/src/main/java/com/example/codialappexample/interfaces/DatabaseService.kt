package com.example.codialappexample.interfaces

import com.example.codialappexample.models.Course
import com.example.codialappexample.models.Group
import com.example.codialappexample.models.Student
import com.example.codialappexample.models.Teacher

interface DatabaseService {

    fun addCourse(course: Course)
    fun getAllCoursesList(): ArrayList<Course>
    fun getCourseById(id: Int): Course

    fun addTeacher(teacher: Teacher)
    fun getAllTeachersList(): ArrayList<Teacher>
    fun editTeacher(teacher: Teacher): Int
    fun deleteTeacher(teacher: Teacher)
    fun getTeacherById(id: Int): Teacher

    fun addGroup(group: Group)
    fun getAllGroupsList(): ArrayList<Group>
    fun editGroup(group: Group): Int
    fun deleteGroup(group: Group)
    fun getGroupById(id: Int): Group
    fun getGroupByMentorId(teacher: Teacher)

    fun addStudent(student: Student)
    fun getAllStudentsList(): ArrayList<Student>
    fun deleteStudent(student: Student)
    fun getStudentByGroupId(group: Group)

}