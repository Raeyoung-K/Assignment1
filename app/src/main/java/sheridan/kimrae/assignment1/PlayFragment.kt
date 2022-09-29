package sheridan.kimrae.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.kimrae.assignment1.databinding.FragmentPlayBinding
import sheridan.kimrae.assignment1.model.Choice
import sheridan.kimrae.assignment1.model.GameData
import sheridan.kimrae.assignment1.model.Option
import sheridan.kimrae.assignment1.model.Prize

class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPlayBinding.inflate(inflater, container, false)

        binding.playButton.setOnClickListener {
            val userChoice = getUserChoice()
            if (userChoice != null)
            {
                mainViewModel.setUserChoice(userChoice)
                findNavController().navigate(R.id.action_playFragment_to_resultFragment)
            }

        }

        return binding.root

    }

    private fun getUserChoice(): GameData? {
        return when (binding.choiceOptions.checkedRadioButtonId) {
            //R.id.option1, R.id.option2, R.id.option3, R.id.option4 -> Prize.getUserRandom()
            R.id.option1 -> Prize.getUserRandom(Option.first)
            R.id.option2 -> Prize.getUserRandom(Option.second)
            R.id.option3 -> Prize.getUserRandom(Option.third)
            R.id.option4 -> Prize.getUserRandom(Option.fourth)
            else -> null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}