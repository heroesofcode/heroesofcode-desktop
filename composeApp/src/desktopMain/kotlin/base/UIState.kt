package base

data class UIState<T>(
    val data: T? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null
)