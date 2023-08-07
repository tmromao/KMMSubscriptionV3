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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import domain.SignInScreenState
import presentation.SignInScreenEvent
import presentation.components.EmailTextField
import presentation.components.PasswordTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    state: SignInScreenState,
    onEvent: (SignInScreenEvent) -> Unit,
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
/*        TextField(
            value = state.email,
            onValueChange = {
                onEvent(SignInScreenEvent.OnEmailChanged(it))
            },
            label = { Text("Enter email") },
            placeholder = { Text("example@domain.com") },
            trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "email info") },
            singleLine = true
        )*/

        EmailTextField(
            state = state,
            onEvent = onEvent,
        )

        Spacer(modifier = Modifier.height(20.dp))

        PasswordTextField(
            state = state,
            onEvent = onEvent,

            )

        /*  //Password TextField
          var passwordHidden by rememberSaveable { mutableStateOf(true) }

          TextField(
              value = state.password,
              onValueChange = {
                  onEvent(SignInScreenEvent.OnPasswordChanged(it))
              },
              label = { Text("Enter password") },

              visualTransformation =
              if (passwordHidden)  PasswordVisualTransformation() else VisualTransformation.None,
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
              trailingIcon = {
                  IconButton(onClick = { passwordHidden = !passwordHidden }) {
                      val visibilityIcon =
                          if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                      // Please provide localized contentDescription for accessibility services
                      val description = if (passwordHidden) { "Show password" } else { "Hide password" }
                      Icon(
                          imageVector = visibilityIcon,
                          contentDescription = description
                      )
                  }
              }
          )*/
        Spacer(Modifier.weight(1f))
    }
}