package domain.model

import kotlinx.serialization.*


@Serializable
data class Post(
    val id: Int,
    val userId: Int,
    val title: String,
    val description: String?,
    val date: Double,
    val body: String,
    val image: String,
    val linkText: String,
    val link: String
)