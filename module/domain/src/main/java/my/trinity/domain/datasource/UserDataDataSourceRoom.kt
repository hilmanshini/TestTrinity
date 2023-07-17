package my.trinity.domain.datasource

import androidx.room.withTransaction
import my.trinity.data.database.UserDataDatabase
import my.trinity.data.database.dao.UserDataDao
import my.trinity.data.entity.UserData
import my.trinity.domain.mapper.UserDataMapper
import my.trinity.domain.model.ResultFlowModel
import my.trinity.domain.model.UserDataModel
import my.trinity.domain.model.asFlowModel
import java.util.Date
import java.util.UUID


class UserDataDataSourceRoom(
    private val userDataDao: UserDataDao,
    private val userDataDb: UserDataDatabase,
    private val userDataMapper: UserDataMapper
) :
    UserDataDataSource {
    override suspend fun saveContact(
        firstName: String,
        lastName: String,
        email: String,
        dob: Date
    ): ResultFlowModel<UserDataModel> = kotlin.runCatching {
        UserData(
            UUID.randomUUID().toString(),
            firstName, lastName, email, dob
        ).run {
            userDataDb.withTransaction {
                userDataDao.saveUserData(
                    this
                )
            }
            userDataMapper.cloneUserData(this)
        }
    }.asFlowModel()

    override suspend fun listUserData(
        query: String
    ): ResultFlowModel<List<UserDataModel>> =
        kotlin.runCatching {
            userDataMapper.cloneUserDataList(userDataDao.queryUserData(query))
        }.asFlowModel()

    override suspend fun getUserData(id: String): ResultFlowModel<UserDataModel?> =
        kotlin.runCatching {
            userDataDao.getUserData(id)?.let { userData -> userDataMapper.cloneUserData(userData) }
        }.asFlowModel()
}