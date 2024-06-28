import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screens.Home

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "heroesofcode-desktop",
    ) {
        Home()
    }
}