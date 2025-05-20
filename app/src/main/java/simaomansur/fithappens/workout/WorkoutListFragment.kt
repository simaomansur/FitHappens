package simaomansur.fithappens.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import simaomansur.fithappens.R
import simaomansur.fithappens.ui.workouts.WorkoutAdapter
import simaomansur.fithappens.ui.workouts.WorkoutsViewModel

class WorkoutListFragment : Fragment() {

    private lateinit var viewModel: WorkoutsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workout_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.workoutRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(this)[WorkoutsViewModel::class.java]

        viewModel.workouts.observe(viewLifecycleOwner) { workoutList ->
            val adapter = WorkoutAdapter(workoutList) { selectedWorkout ->
                val action = WorkoutListFragmentDirections
                    .actionWorkoutListFragmentToWorkoutDetailFragment(selectedWorkout.id)
                findNavController().navigate(action)
            }
            recyclerView.adapter = adapter
        }
    }
}
