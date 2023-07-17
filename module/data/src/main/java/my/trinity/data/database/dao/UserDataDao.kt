package my.trinity.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import my.trinity.data.entity.UserData


@Dao
interface UserDataDao {

    @Query("SELECT * FROM UserData WHERE id=:id")
    suspend fun getUserData(id: String): UserData?


    @Query("SELECT * FROM UserData firstName  WHERE firstName like :query or lastName like :query or email like :query ")
    suspend fun queryUserData(query: String): List<UserData>


    @Query("SELECT * FROM UserData firstName   ")
    suspend fun allData(): List<UserData>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun saveUserData(employee: UserData)


    @Query("DELETE  FROM UserData ")
    suspend fun clear()



    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun saveUserDataList(employee: List<UserData>)
}