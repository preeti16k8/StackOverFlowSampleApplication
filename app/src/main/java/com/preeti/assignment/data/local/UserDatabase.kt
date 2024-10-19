package com.preeti.assignment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.preeti.assignment.data.model.StackUser
import com.preeti.assignment.data.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [StackUser::class], version = 2)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getArticleDao(): UserDao

    class Callback @Inject constructor(
        private val database: Provider<UserDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}