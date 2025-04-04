package com.ozalp.kararsizim.presentation.compose.haveAProblemScreen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ozalp.kararsizim.R
import com.ozalp.kararsizim.presentation.viewmodel.HaveAProblemScreenViewModel

@Composable
fun HaveAProblemScreen(viewModel: HaveAProblemScreenViewModel, goToBack: () -> Unit) {

    var textField by remember { mutableStateOf("") }
    val context = LocalContext.current
    val screenState = viewModel.screenState

    val errorMessage = stringResource(R.string.unkown_error)

    LaunchedEffect(screenState.value.success) {
        if (screenState.value.success == true) {
            goToBack()
        } else if (screenState.value.success == false) {
            Toast.makeText(
                context,
                errorMessage,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.contact_us),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            TextField(
                value = textField,
                onValueChange = { textField = it },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(stringResource(R.string.contact_us)) },
                placeholder = { Text(stringResource(R.string.contact_us)) },
                singleLine = false,
                maxLines = 5,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )

            Button(
                onClick = {
                    viewModel.sendMessage(context = context, textField)
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = textField.isNotBlank()
            ) {
                Text(text = stringResource(R.string.send))
            }
        }
    }
}
