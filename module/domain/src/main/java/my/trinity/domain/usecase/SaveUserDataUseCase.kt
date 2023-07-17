package my.trinity.domain.usecase

import kotlinx.coroutines.flow.flow
import my.trinity.domain.datasource.UserDataDataSource
import java.util.Date

class SaveUserDataUseCase(private val userDataDataSource: UserDataDataSource) {

    suspend operator fun invoke(firstName: String, lastName: String, email: String, dob: Date) =
        flow {
            emit(userDataDataSource.saveContact(firstName, lastName, email, dob))
        }
}