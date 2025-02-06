package simaomansur.fithappens.model

data class Workout(
    val id: Int,
    val name: String,
    val exercises: List<Exercise> = emptyList()
)