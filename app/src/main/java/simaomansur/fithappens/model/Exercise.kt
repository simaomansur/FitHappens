package simaomansur.fithappens.model

data class Exercise(
    val id: Int,
    val name: String,
    val sets: List<ExerciseSet> = emptyList()
)