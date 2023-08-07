package presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import domain.SignInScreenState
import presentation.SignInScreenEvent
import presentation.components.EmailTextField
import presentation.components.PasswordTextField
import presentation.navigation.NavHomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
) {

    val navigator = LocalNavigator.currentOrThrow
    val viewModel = getViewModel(
        key = "sign-in-screen",
        factory = viewModelFactory {
            SignInScreenViewModel()
        }
    )

    val state by viewModel.state.collectAsState()

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        EmailTextField(
            state = state,
            onEvent = viewModel::onEvent,
        )

        Spacer(modifier = Modifier.height(20.dp))

        PasswordTextField(
            state = state,
            onEvent = viewModel::onEvent,

            )

        Button(
            onClick = {
                //viewModel.onEvent(SignInScreenEvent.OnSignInClicked)
                //TODO: Add logic to check if user is signed in, confirm email, password.
                // If so, navigate to home screen
                navigator.push(NavHomeScreen)
            },
            modifier = Modifier.height(50.dp)
        ) {
            Text("Sign In")
        }


        Spacer(Modifier.weight(1f))
    }
}