package com.example.codialappexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.codialappexample.models.Course
import com.example.codialappexample.models.Group
import com.example.codialappexample.models.Student
import com.example.codialappexample.models.Teacher

@Database(entities = [Course::class, Teacher::class, Group::class, Student::class], version = 1)
abstract class MyDataBase : RoomDatabase() {

    abstract fun courseDao(): CourseDao
    abstract fun teacherDao(): TeacherDao
    abstract fun groupDao(): GroupDao
    abstract fun studentDao(): StudentDao
    companion object {
        private var instance: MyDataBase? = null

        @Synchronized
        fun getInstance(context: Context): MyDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDataBase::class.java,
                    "roomDataBase_db"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}