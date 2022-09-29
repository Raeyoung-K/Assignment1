package sheridan.kimrae.assignment1.model

data class GameData(
    val userChoice: Choice,
    val option1: Choice,
    val option2: Choice,
    val option3: Choice,
    val seat: Option

    // userChoice is userChoice
    // option1, option2, option3 are the rest of the options in order after subtracting the user choice
    // ex) if user choices Option3, then Option1 is option1, Option2 is option2, Option4 is option3.
)
