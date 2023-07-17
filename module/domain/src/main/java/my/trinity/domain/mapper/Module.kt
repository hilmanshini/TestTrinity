package my.trinity.domain.mapper

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun provideUserDataMapper(): UserDataMapper =
        Mappers.getMapper(UserDataMapper::class.java)
}