package my.trinity.domain.datasource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import my.trinity.data.database.UserDataDatabase
import my.trinity.data.database.dao.UserDataDao
import my.trinity.domain.mapper.UserDataMapper

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    fun provideUserDataDataSource(
        userDataDao: UserDataDao,
        userDataDb: UserDataDatabase,
        mapper: UserDataMapper
    ): UserDataDataSource = UserDataDataSourceRoom(userDataDao, userDataDb,mapper)

}