package tr.com.atakan.hdgbootcamp.ui.model

data class Talk(
    val title: String,
    val speaker: String,
    val date: String,
    val duration: Long,
    val subjects: Set<String>,
    val active: Boolean = true,
    val image: Int
)
