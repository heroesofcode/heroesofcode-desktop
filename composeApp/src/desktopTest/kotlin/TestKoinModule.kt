import io.mockk.mockk
import network.ApiClient
import org.koin.dsl.module
import repository.InfoRepository
import viewmodel.InfoViewModel

val testModule = module {
    single { mockk<ApiClient>(relaxed = true) }
    single { InfoRepository(get()) }
}