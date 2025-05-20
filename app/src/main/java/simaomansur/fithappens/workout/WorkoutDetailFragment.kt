package simaomansur.fithappens.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import simaomansur.fithappens.R
import simaomansur.fithappens.model.Exercise
import simaomansur.fithappens.model.Workout

class WorkoutDetailFragment : Fragment() {

    private val args: WorkoutDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workoutId = args.id

        // Dummy workout for display
        val workout = Workout(
            id = workoutId,
            name = "Full Body Blast",
            exercises = listOf(
                Exercise("Bench Press", 3),
                Exercise("Squat", 4),
                Exercise("Deadlift", 3)
            )
        )

        // Set the workout title at the top
        val workoutNameText = view.findViewById<TextView>(R.id.workoutTitleText)
        workoutNameText.text = workout.name

        // Get the container to add exercises dynamically
        val container = view.findViewById<LinearLayout>(R.id.exerciseContainer)

        for (exercise in workout.exercises) {
            // Inflate layout for each exercise
            val exerciseView = layoutInflater.inflate(R.layout.item_exercise, container, false)

            // Set exercise name
            val exerciseNameText = exerciseView.findViewById<TextView>(R.id.exerciseName)
            exerciseNameText.text = exercise.name

            // Add input fields for each set
            for (i in 1..exercise.sets) {
                val setRow = LinearLayout(requireContext()).apply {
                    orientation = LinearLayout.HORIZONTAL
                    setPadding(0, 8, 0, 0)
                }

                val weightInput = EditText(requireContext()).apply {
                    layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
                    hint = "Weight"
                    inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
                }

                val repsInput = EditText(requireContext()).apply {
                    layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
                    hint = "Reps"
                    inputType = android.text.InputType.TYPE_CLASS_NUMBER
                }

                setRow.addView(weightInput)
                setRow.addView(repsInput)
                (exerciseView as LinearLayout).addView(setRow)
            }

            container.addView(exerciseView)
        }
    }
}
