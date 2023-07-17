package my.trinity.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import my.trinity.data.database.DateConverter
import java.util.Date


/***
 * Entity for saving user data
 */
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass



@JsonClass(generateAdapter = true)
@Entity(tableName = "UserData")
@TypeConverters(value = [DateConverter::class])
data class UserData(


    @field:Json(name = "id")
    @PrimaryKey @ColumnInfo(name = "id") var id: String,

    @field:Json(name = "firstName")
    @ColumnInfo(name = "firstName") val firstName: String? = null,


    @field:Json(name = "lastName")
    @ColumnInfo(name = "lastName") val lastName: String? = null,


    @field:Json(name = "email")
    @ColumnInfo(name = "email") val email: String? = null,


    @field:Json(name = "dob")
    @ColumnInfo(name = "dob") val dob: Date? = null
)