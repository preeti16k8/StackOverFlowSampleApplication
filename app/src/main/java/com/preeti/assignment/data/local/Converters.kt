package com.preeti.assignment.data.local

import androidx.room.TypeConverter
import com.preeti.assignment.data.model.Badge

class Converters {

    @TypeConverter
    fun fromSource(source: Badge): Int?{
        return source.bronze
    }

    @TypeConverter
    fun toSource(name: Int): Badge {
        return Badge(name, name, name)
    }
}