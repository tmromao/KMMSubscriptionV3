package presentation.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.SignInScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import presentation.SignInScreenEvent

class SignInScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignInScreenState())
    val state = _state.asStateFlow()

    var email: String by mutableStateOf("")
        private set

    var password: String by mutableStateOf("")
        private set

    fun onEvent(event: SignInScreenEvent) {
    }

}