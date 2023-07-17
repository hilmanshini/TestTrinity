package my.trinity.domain.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import my.trinity.domain.datasource.UserDataDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun provideGetUserDataUseCase(userDataDataSource: UserDataDataSource) =
        GetUserDataUseCase(userDataDataSource)


    @Provides
    @Singleton
    fun provideListUserDataUseCase(userDataDataSource: UserDataDataSource) =
        ListUserDataUseCase(userDataDataSource)

    @Provides
    @Singleton
    fun provideSaveUserDataUseCase(userDataDataSource: UserDataDataSource) =
        SaveUserDataUseCase(userDataDataSource)

}