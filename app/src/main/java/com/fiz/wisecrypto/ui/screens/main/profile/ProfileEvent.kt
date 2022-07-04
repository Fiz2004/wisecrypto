package com.fiz.wisecrypto.ui.screens.main.profile

sealed class ProfileEvent {
    object ListTransactionsClicked : ProfileEvent()
    object PrivacyClicked : ProfileEvent()
    object PaymentClicked : ProfileEvent()
    object NotificationsClicked : ProfileEvent()
    object ProfileExitClicked : ProfileEvent()
    object PullClicked : ProfileEvent()
    object AddClicked : ProfileEvent()
    object ChangeAvatarClicked : ProfileEvent()
}