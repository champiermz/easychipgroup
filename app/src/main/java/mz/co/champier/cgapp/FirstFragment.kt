package mz.co.champier.cgapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import mz.co.champier.easychipgroup.EasyChipGroup

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chipGroup = view.findViewById<EasyChipGroup<Gender>>(R.id.chip_group)


        val list = listOf(
                Gender('M', "Masculino"),
                Gender('F', "Feminino")
        )
        chipGroup.submitList(list) { chip, element ->
            chip.text = element.value
        }

        chipGroup.setOnItemClickListener { element ->
            Toast.makeText(requireContext(), element.key + "", Toast.LENGTH_SHORT).show()
        }
    }
}