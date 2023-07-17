package my.trinity.data.database

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import my.trinity.data.database.dao.UserDataDao
import my.trinity.data.entity.UserData
import my.trinity.test.module.data.R
import okio.ByteString.Companion.readByteString
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, UserDataDatabase::class.java, "user_database.db")
            .fallbackToDestructiveMigration()
            .build().apply {
                runBlocking {
                    userDataDao.clear()
                    loadRaw(context, userDataDao)
                }
            }


    private fun loadRaw(context: Context, userDataDao: UserDataDao) {
        val moshi = Moshi.Builder().add(CustomDateAdapter()).build()
        val type: java.lang.reflect.Type = Types.newParameterizedType(
            List::class.java,
            UserData::class.java
        )
        context.resources.openRawResource(R.raw.data).use {
            val s = moshi.adapter<List<UserData>>(type).fromJson(it.reader().readText()).orEmpty()
            runBlocking {
                s.forEach {
                    userDataDao.saveUserData(it)
                }
//                userDataDao.saveUserDataList(s)
            }
        }
    }

    @Singleton
    @Provides
    fun provideUserDataDao(userDataDatabase: UserDataDatabase): UserDataDao =
        userDataDatabase.userDataDao

}