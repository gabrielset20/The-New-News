package edu.ifam.thenewnews.db

import androidx.room.TypeConverter
import edu.ifam.thenewnews.models.Source

class Converts {

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}