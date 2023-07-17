package my.trinity.view.save_user_data

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import my.trinity.domain.model.ResultFlowModel
import my.trinity.domain.model.UserDataModel
import my.trinity.domain.usecase.SaveUserDataUseCase
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class AddUserDataViewModel @Inject constructor(
    val saveUserDataUseCase: SaveUserDataUseCase
) : ViewModel() {

    val firstName = MutableStateFlow<String>("")
    val lastName = MutableStateFlow<String>("")
    val email = MutableStateFlow<String>("")
    val dob = MutableStateFlow<String>("")
    val result = MutableStateFlow<ResultFlowModel<UserDataModel>>(ResultFlowModel.None())
    val validation = MutableStateFlow<String>("")

    fun saveData() {
        if (firstName.value.isEmpty() || lastName.value.isEmpty() || email.value.isEmpty() || dob.value.isEmpty()) {
            validation.value = "Invalid Form"
            return
        }
        viewModelScope.launch {
            saveUserDataUseCase(
                firstName.value,
                lastName.value,
                email.value,
                Date(dob.value.toLong())
            ).collect {
                result.value = it
            }
        }
    }
}