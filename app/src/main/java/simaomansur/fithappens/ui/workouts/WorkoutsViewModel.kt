package simaomansur.fithappens.ui.workouts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import simaomansur.fithappens.model.Workout

class WorkoutsViewModel : ViewModel() {

    val text = MutableLiveData("Workouts Fragment")
    private val _workouts = MutableLiveData<List<Workout>>().apply {
        value = listOf(
            Workout(id = 1, name = "Full Body Blast"),
            Workout(id = 2, name = "Upper Body Strength"),
            Workout(id = 3, name = "Cardio Burn")
        )
    }

    val workouts: LiveData<List<Workout>> = _workouts
}
