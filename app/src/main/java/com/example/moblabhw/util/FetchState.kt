package com.example.moblabhw.util

sealed class FetchState<out R> {
    data class Error(val exception: Exception) : FetchState<Nothing>()
    object Loading : FetchState<Nothing>()
    object Success : FetchState<Nothing>()
}