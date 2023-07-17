package my.trinity.domain.usecase

import kotlinx.coroutines.flow.flow
import my.trinity.domain.datasource.UserDataDataSource

class ListUserDataUseCase(private val userDataDataSource: UserDataDataSource) {

    suspend operator fun invoke(query: String = "%%",) = flow {
        emit(
            userDataDataSource.listUserData(query)
        )
    }
}