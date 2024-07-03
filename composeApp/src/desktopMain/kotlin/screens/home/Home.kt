package screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import viewmodel.InfoViewModel

@Composable
fun Home(viewModel: InfoViewModel) {

    val uiState by viewModel.state.collectAsState()

    val data = uiState.data
    val isLoading = uiState.isLoading
    val error = uiState.error

    DisposableEffect(Unit) {
        onDispose {
            viewModel.onCleared()
        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetchInfo()
    }
    Column(
        modifier = Modifier.fillMaxWidth().padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator()
                }

                data != null -> {
                    InfoView(data)
                }

                error != null -> {
                    Text("Error: ${error.message}")
                }

                else -> {
                    Text("No data")
                }
            }
        }
    }
}