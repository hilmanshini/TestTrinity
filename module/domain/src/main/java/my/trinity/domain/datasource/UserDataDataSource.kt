package my.trinity.domain.datasource

import my.trinity.data.entity.UserData
import my.trinity.domain.model.ResultFlowModel
import my.trinity.domain.model.UserDataModel
import java.util.Date

/***
 *The datasource as used to be used in our domain
 * Responsibility :
 * 1. Saving contact
 * 2. Searching contact based on query
 * 3. Retrieve the contact list
 * 4. Get the contact by ID
 */
interface UserDataDataSource {

    suspend fun saveContact(
        firstName: String,
        lastName: String,
        email: String,
        dob: Date
    ): ResultFlowModel<UserDataModel>

    suspend fun listUserData(query: String = ""): ResultFlowModel<List<UserDataModel>>

    suspend fun getUserData(id: String): ResultFlowModel<UserDataModel?>

}