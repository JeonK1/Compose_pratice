package com.xemic.composeplayground.common.model

data class UiState<out T>(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val data: T? = null
)