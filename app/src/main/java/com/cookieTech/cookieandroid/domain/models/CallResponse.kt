package com.cookieTech.cookieandroid.domain.models

class CallResponse<T> {
    var networkState = NetworkState.Idle
    var message = "Error"
    var progress = 0.0f
    var data: T? = null
}