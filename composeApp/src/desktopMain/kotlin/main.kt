import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.appModule
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import screens.home.Home
import viewmodel.InfoViewModel
import org.koin.java.KoinJavaComponent.get

fun main() = application {
    startKoin {
        modules(appModule)
    }

    Window(
        onCloseRequest = {
            stopKoin()
            exitApplication()
        },
        title = "Heroes Of Code - Open Source",
    ) {
        val viewModel: InfoViewModel = get(InfoViewModel::class.java)
        Home(viewModel = viewModel)
    }
}