package presentation

sealed interface UiSignInScreenEvents {
    object SignInButtonClicked : UiSignInScreenEvents
    data class OnEmailChanged(val email: String) : UiSignInScreenEvents
    data class OnPasswordChanged(val password: String) : UiSignInScreenEvents
}