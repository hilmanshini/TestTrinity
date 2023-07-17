package my.trinity.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import my.trinity.data.database.dao.UserDataDao
import my.trinity.data.entity.UserData
import my.trinity.test.module.data.BuildConfig
import java.util.Date


@Database(
    entities = [
        UserData::class
    ],
    version = 8,
    exportSchema = false,
)
abstract class UserDataDatabase : RoomDatabase() {
    abstract val userDataDao: UserDataDao
}

object DateConverter {
    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return dateLong?.let { Date(it) }
//        return Date()
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }
}