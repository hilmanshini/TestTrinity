package my.trinity.domain.model

import kotlinx.coroutines.flow.MutableStateFlow

sealed class ResultFlowModel<T> {
    class None<T> : ResultFlowModel<T>()
    class Success<T>(val result: T) : ResultFlowModel<T>()
    class Error<T>(val throwable: Throwable) : ResultFlowModel<T>()
}

fun <T> stateFlowOf() = MutableStateFlow<ResultFlowModel<T>>(ResultFlowModel.None())


fun <T> Result<T>.asFlowModel(): ResultFlowModel<T> {
    if (isSuccess) {
        return ResultFlowModel.Success(getOrThrow())
    } else {

        return ResultFlowModel.Error(requireNotNull(exceptionOrNull()))
    }
}