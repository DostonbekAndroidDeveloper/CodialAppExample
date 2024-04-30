package com.example.codialappexample.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.codialappexample.models.Teacher

@Dao
interface TeacherDao {

    @Insert
    fun insertTeacher(teacher: Teacher)

    @Query("SELECT * FROM teacher")
    fun getAllTeachers(): List<Teacher>

    @Query("SELECT * FROM teacher where id=:id")
    fun getTeachersById(id: Int): Teacher

    @Update
    fun updateTeacher(teacher: Teacher)

    @Delete
    fun deleteTeacher(teacher: Teacher)


}