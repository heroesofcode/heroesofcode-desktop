package viewmodel

import UIState
import dto.InfoDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import repository.InfoRepository

class InfoViewModel(private val repository: InfoRepository) {

    private val _state = MutableStateFlow(UIState<InfoDTO>())
    val state: StateFlow<UIState<InfoDTO>> = _state

    private val viewModelScope: CoroutineScope = MainScope()

    fun fetchInfo() {
        viewModelScope.launch {
            _state.value = UIState(isLoading = true)
            val result = repository.getInto()

            _state.value = if (result.isSuccess) {
                UIState(data = result.getOrNull())
            } else {
                UIState(error = result.exceptionOrNull())
            }
        }
    }

    fun onCleared() {
        viewModelScope.cancel()
    }
}