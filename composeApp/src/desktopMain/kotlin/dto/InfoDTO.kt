package dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoDTO(
    val description: String? = null,
    val name: String? = null,
    val followers: Int? = null,
    val following: Int? = null,
    @SerialName("avatar_url") val avatarUrl: String? = null
)
