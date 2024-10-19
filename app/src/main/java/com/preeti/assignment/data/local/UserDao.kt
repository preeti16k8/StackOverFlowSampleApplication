package com.preeti.assignment.data.local
import androidx.room.*
import com.preeti.assignment.data.model.StackUser

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getArticles() : List<StackUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: StackUser) : Long

    @Delete
    suspend fun delete(article: StackUser)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllArticles()
}