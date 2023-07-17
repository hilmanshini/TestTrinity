package my.trinity.domain.usecase

import kotlinx.coroutines.flow.flow
import my.trinity.domain.datasource.UserDataDataSource

class GetUserDataUseCase(private val userDataDataSource: UserDataDataSource) {

    suspend operator fun invoke(id: String) = flow {
        emit(userDataDataSource.getUserData(id))
    }
}