package dto

import kotlinx.serialization.Serializable

@Serializable
data class InfoDTO(
    val description: String? = null,
    val name: String? = null,
    val followers: Int? = null,
    val following: Int? = null,
    val avatar_url: String? = null
)
