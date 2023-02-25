package com.example.myquizapp

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
//        1
        val que1 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Australia",
            "Argentina",
            "India",
            "USA",
            2)
//        2
        val que2 = Question(2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Fiji",
            "Germany",
            "Kuwait",
            "Australia",
            4)
//        3
        val que3 = Question(3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "India",
            "New Zealand",
            "Denmark",
            1)
//        4
        val que4 = Question(4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "Fiji",
            "Brazil",
            "New Zealand",
            3)
//        5
        val que5 = Question(5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Australia",
            "Argentina",
            "Denmark",
            "Kuwait",
            3)
//        6
        val que6 = Question(6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Fiji",
            "India",
            "Denmark",
            "Brazil",
            1)
//        7
        val que7 = Question(7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "New Zealand",
            "Germany",
            "Belgium",
            "Argentina",
            2)
//        8
        val que8 = Question(8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Denmark",
            "Brazil",
            "Argentina",
            "India",
            4)
//        9
        val que9 = Question(9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Australia",
            "Kuwait",
            "New Zealand",
            "India",
            2)
//        10
        val que10 = Question(10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "Denmark",
            "New Zealand",
            "Fiji",
            3)
        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        return questionsList
    }
}