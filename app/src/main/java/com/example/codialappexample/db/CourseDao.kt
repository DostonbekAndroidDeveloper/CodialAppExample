package com.example.codialappexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.codialappexample.models.Course
import com.example.codialappexample.models.Group

@Dao
interface CourseDao {

    @Insert
    fun insertCourse(course: Course)

    @Query("SELECT * FROM course")
    fun getAllCourse(): List<Course>

    @Query("SELECT * FROM `course` where id=:id")
    fun getGroupById(id:Int): Group





}