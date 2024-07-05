package dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoDTO(
    val description: String,
    val name: String,
    val followers: Int,
    val following: Int,
    @SerialName("avatar_url") val avatarUrl: String
)
