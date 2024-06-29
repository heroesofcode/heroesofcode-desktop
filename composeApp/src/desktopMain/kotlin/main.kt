import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.appModule
import org.koin.core.context.GlobalContext.startKoin
import screens.Home

fun main() = application {
    startKoin {
        modules(appModule)
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "Heroes Of Code - Open Source",
    ) {
        Home()
    }
}