package my.trinity.domain.mapper

import my.trinity.domain.model.UserDataModel
import my.trinity.data.entity.UserData as UserDataEntity
import org.mapstruct.Mapper
import org.mapstruct.control.DeepClone


@Mapper(mappingControl = DeepClone::class)
interface UserDataMapper {
    fun cloneUserData(userData: UserDataEntity): UserDataModel
    fun cloneUserDataList(userData: List<UserDataEntity>): List<UserDataModel>
}