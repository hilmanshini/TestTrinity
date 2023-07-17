package my.trinity.view.list_user_data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import my.trinity.domain.model.UserDataModel
import my.trinity.domain.model.stateFlowOf
import my.trinity.domain.usecase.ListUserDataUseCase
import javax.inject.Inject

@HiltViewModel
class ListUserViewModel @Inject constructor(
    val listUseCase: ListUserDataUseCase
) : ViewModel() {

    val listResult = stateFlowOf<List<UserDataModel>>()


    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            listUseCase().collect {
                listResult.value = it
            }
        }
    }

    fun query(){
        viewModelScope.launch {
            listUseCase().collect {
                listResult.value = it
            }
        }
    }
}