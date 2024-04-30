import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.zoo.R

class AnimalDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the selected animal's data from arguments
        val animalName = arguments?.getString("animalName")
        val animalContinent = arguments?.getString("animalContinent")

        // Update the UI with the selected animal's data
        view.findViewById<TextView>(R.id.animal_name).text = animalName
        view.findViewById<TextView>(R.id.animal_continent).text = animalContinent
        val backgroundColor = when (animalContinent) {
            "Europe" -> R.color.green
            "Africa" -> R.color.yellow
            "Asia" -> R.color.red
            "North America" -> R.color.brown
            "South America" -> R.color.orange
            "Australia" -> R.color.purple
            "Antarctica" -> R.color.blue
            else -> android.R.color.transparent // Default transparent color if continent not found
        }
        view.setBackgroundColor(ContextCompat.getColor(requireContext(), backgroundColor))

    }
}
