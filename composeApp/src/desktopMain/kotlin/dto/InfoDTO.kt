package dto

import kotlinx.serialization.Serializable

@Serializable
data class InfoDTO(
    val description: String? = null,
    val name: String? = null,
    val followers: String? = null,
    val following: String? = null
)
