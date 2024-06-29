package network

import dto.InfoDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ApiClient(private val client: HttpClient) {

    suspend fun getInfo(): Flow<InfoDTO> {
        val info = client
            .get("https://api.github.com/orgs/heroesofcode")
            .body<InfoDTO>()

        return MutableStateFlow(info)
    }
}