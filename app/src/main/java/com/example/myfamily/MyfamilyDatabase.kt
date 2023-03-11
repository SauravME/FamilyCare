package com.example.myfamily

import androidx.room.Database

@Database(entities = [ContactModel::class], version = 1, exportSchema = false)
public  abstract class MyfamilyDatabase {
   abstract fun contactDao():ContactDao

}