package simaomansur.fithappens.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import simaomansur.fithappens.R
import simaomansur.fithappens.ui.workouts.WorkoutAdapter
import simaomansur.fithappens.ui.workouts.Workout

class WorkoutListFragment : Fragment() {

    // Dummy data – replace with your actual data source
    private val workoutList = listOf(
        Workout(id = 1, name = "Full Body Blast"),
        Workout(id = 2, name = "Upper Body Strength"),
        Workout(id = 3, name = "Cardio Burn")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workout_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.workoutRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = WorkoutAdapter(workoutList) { selectedWorkout ->
            // When a workout is selected, navigate to the Workout Detail Fragment.
            // You can pass the workout id or details as arguments.
            val action = WorkoutListFragmentDirections.actionWorkoutListFragmentToWorkoutDetailFragment(selectedWorkout.id)
            findNavController().navigate(action)
        }
        recyclerView.adapter = adapter
    }
}
