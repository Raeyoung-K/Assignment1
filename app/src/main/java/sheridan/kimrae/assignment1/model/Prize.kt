package sheridan.kimrae.assignment1.model

import android.widget.RadioButton
import com.google.android.material.chip.Chip
import sheridan.kimrae.assignment1.R

class Prize {

    companion object {
        // randomize the options


        //val prizes = mutableListOf(Choice.IPHONE, Choice.CANDY, Choice.HUNDRED, Choice.WATERBOTTLE)

        fun player(userChoice: GameData) =
            GameData(userChoice.userChoice, userChoice.option1, userChoice.option2, userChoice.option3, userChoice.seat)

        // get user's and the others and put the data in GameData and return it.
        // get Option as a parameter to use it later in ResultFragment
        fun getUserRandom(seat: Option): GameData {
            val prizes = mutableListOf(Choice.IPHONE, Choice.CANDY, Choice.HUNDRED, Choice.WATERBOTTLE)
            val users = prizes.random()
            prizes.remove(users)
            val option1 = prizes.random()
            prizes.remove(option1)
            val option2 = prizes.random()
            prizes.remove(option2)
            val option3 = prizes.random()
            return GameData(users, option1, option2, option3, seat)
        }
    }
}

