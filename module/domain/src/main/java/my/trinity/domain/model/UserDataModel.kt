package my.trinity.domain.model

import java.util.Date

data class UserDataModel(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val dateOfBirth: Date?
)