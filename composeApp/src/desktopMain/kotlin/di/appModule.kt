package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import network.ApiClient
import org.koin.core.module.Module
import org.koin.dsl.module
import repository.InfoRepository
import viewmodel.InfoViewModel

val appModule: Module = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    factory { ApiClient(get()) }
    factory { InfoRepository(get()) }
    factory { InfoViewModel(get()) }
}