package sheridan.kimrae.assignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sheridan.kimrae.assignment1.model.Choice
import sheridan.kimrae.assignment1.model.GameData
import sheridan.kimrae.assignment1.model.Prize

class MainViewModel : ViewModel() {

    private val _liveGameData = MutableLiveData<GameData>()
    val liveGameData: LiveData<GameData> = _liveGameData

    fun setUserChoice(userChoice: GameData) {
        _liveGameData.value = Prize.player(userChoice)
    }
}