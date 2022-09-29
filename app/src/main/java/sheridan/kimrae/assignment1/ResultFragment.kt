package sheridan.kimrae.assignment1

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.kimrae.assignment1.databinding.FragmentResultBinding
import sheridan.kimrae.assignment1.model.Choice
import sheridan.kimrae.assignment1.model.GameData
import sheridan.kimrae.assignment1.model.Option
import sheridan.kimrae.assignment1.model.Prize

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {


    private var _binding : FragmentResultBinding? = null

    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()


    //@SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_result, container, false)

        _binding = FragmentResultBinding.inflate(inflater, container, false)

        mainViewModel.liveGameData.observe(viewLifecycleOwner) { gameData ->
            updatedOutput(gameData)
        }

        binding.againButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    private fun updatedOutput(gameData: GameData) {
        when(gameData.seat) {
            // if the gameData.seat is Option.first, then Option1 should be the user's choice in the Result View.
            Option.first -> {
                binding.ImageView1Prize.text = choiceToString(gameData.userChoice)
                binding.ImageView2Prize.text = choiceToString(gameData.option1)
                binding.ImageView3Prize.text = choiceToString(gameData.option2)
                binding.ImageView4Prize.text = choiceToString(gameData.option3)
                binding.resultPrize.text = "You got ${choiceToString(gameData.userChoice)}"
                binding.imageView1.setImageResource(choiceToImage(gameData.userChoice))
                binding.imageView2.setImageResource(choiceToImage(gameData.option1))
                binding.imageView3.setImageResource(choiceToImage(gameData.option2))
                binding.imageView4.setImageResource(choiceToImage(gameData.option3))
            }
            Option.second -> {
                binding.ImageView1Prize.text = choiceToString(gameData.option1)
                binding.ImageView2Prize.text = choiceToString(gameData.userChoice)
                binding.ImageView3Prize.text = choiceToString(gameData.option2)
                binding.ImageView4Prize.text = choiceToString(gameData.option3)
                binding.resultPrize.text = "You got ${choiceToString(gameData.userChoice)}"
                binding.imageView1.setImageResource(choiceToImage(gameData.option1))
                binding.imageView2.setImageResource(choiceToImage(gameData.userChoice))
                binding.imageView3.setImageResource(choiceToImage(gameData.option2))
                binding.imageView4.setImageResource(choiceToImage(gameData.option3))
            }
            Option.third -> {
                binding.ImageView1Prize.text = choiceToString(gameData.option1)
                binding.ImageView2Prize.text = choiceToString(gameData.option2)
                binding.ImageView3Prize.text = choiceToString(gameData.userChoice)
                binding.ImageView4Prize.text = choiceToString(gameData.option3)
                binding.resultPrize.text = "You got ${choiceToString(gameData.userChoice)}"
                binding.imageView1.setImageResource(choiceToImage(gameData.option1))
                binding.imageView2.setImageResource(choiceToImage(gameData.option2))
                binding.imageView3.setImageResource(choiceToImage(gameData.userChoice))
                binding.imageView4.setImageResource(choiceToImage(gameData.option3))
            }
            Option.fourth -> {
                binding.ImageView1Prize.text = choiceToString(gameData.option1)
                binding.ImageView2Prize.text = choiceToString(gameData.option2)
                binding.ImageView3Prize.text = choiceToString(gameData.option3)
                binding.ImageView4Prize.text = choiceToString(gameData.userChoice)
                binding.resultPrize.text = "You got ${choiceToString(gameData.userChoice)}"
                binding.imageView1.setImageResource(choiceToImage(gameData.option1))
                binding.imageView2.setImageResource(choiceToImage(gameData.option2))
                binding.imageView3.setImageResource(choiceToImage(gameData.option3))
                binding.imageView4.setImageResource(choiceToImage(gameData.userChoice))
            }

        }
    }

    // change the Choice to String
    private fun choiceToString(choice: Choice): String {
        return when (choice) {
            Choice.IPHONE -> "IPhone"
            Choice.HUNDRED -> "100$"
            Choice.WATERBOTTLE -> "Water Bottle"
            Choice.CANDY -> "Candy"
        }
    }
    // change the Choice to Image
    private fun choiceToImage(choice: Choice): Int {
        return when (choice) {
            Choice.IPHONE -> R.drawable.iphone
            Choice.HUNDRED -> R.drawable.hundred
            Choice.WATERBOTTLE -> R.drawable.bottle
            Choice.CANDY -> R.drawable.candy
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}