package repository

import dto.InfoDTO
import network.ApiClient

class InfoRepository(private val apiClient: ApiClient) {

    suspend fun getInfo(): Result<InfoDTO> {
        return try {
            val info = apiClient.getInfo()
            Result.success(info)
        } catch (error: Exception) {
            Result.failure(error)
        }
    }
}