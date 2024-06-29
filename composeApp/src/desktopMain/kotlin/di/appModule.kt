package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json()
            }
            install(HttpCache)
        }
    }
}