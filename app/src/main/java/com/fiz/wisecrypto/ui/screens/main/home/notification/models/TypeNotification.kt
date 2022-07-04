package com.fiz.wisecrypto.ui.screens.main.home.notification.models

sealed class TypeNotification {
    object Info : TypeNotification()
    data class Transaction(val value: Double) : TypeNotification()
    data class Balance(val value: Int) : TypeNotification()
}