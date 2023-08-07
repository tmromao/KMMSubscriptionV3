package domain

data class SignInScreenState(
    val email: String = "",
    val password: String ="",
    val isUserLoggedIn: Boolean = false,
    //val isSignInButtonEnabled: Boolean = true,
    //val passwordVisibility: Boolean = true,
)
