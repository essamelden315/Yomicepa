package com.example.yomicepa.network

sealed class APIState {
    class Success<T>(val data: T) : APIState()
    class Failure(val error: Throwable) : APIState()
    data object Loading : APIState()
}