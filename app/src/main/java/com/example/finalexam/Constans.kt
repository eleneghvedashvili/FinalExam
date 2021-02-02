package com.example.finalexam

object Constans {

    fun getQuestion (): ArrayList<Questions>{

        val questionList = ArrayList<Questions>()

        //1
        val question1 = Questions(
                1,
                "What subject does this person teach us?",
                R.drawable.xatiashvili,
                "Introduction to Entrepreneurship",
                "Calculus",
                "Mobile applications",
                "Basics of Computer Networking",
                "Python",
                "Principles of digital technology",
                1
        )
        questionList.add(question1)

        //2
        val question2 = Questions(
                2,
                "What subject does this person teach us?",
                R.drawable.batoninikolozi,
                "Introduction to Entrepreneurship",
                "Calculus",
                "Mobile applications",
                "Basics of Computer Networking",
                "Python",
                "Principles of digital technology",
                3
        )
        questionList.add(question2)


        //3
        val question3 = Questions(
                3,
                "What subject does this person teach us?",
                R.drawable.batonirevazi,
                "Introduction to Entrepreneurship",
                "Calculus",
                "Mobile applications",
                "Basics of Computer Networking",
                "Python",
                "Principles of digital technology",
                2
        )
        questionList.add(question3)

        //4
        val question4 = Questions(
                4,
                "What subject does this person teach us?",
                R.drawable.malxazi,
                "Introduction to Entrepreneurship",
                "Calculus",
                "Mobile applications",
                "Basics of Computer Networking",
                "Python",
                "Principles of digital technology",
                1
        )
        questionList.add(question4)

        //5
        val question5 = Questions(
                5,
                "What subject does this person teach us?",
                R.drawable.qalbatonigvanca,
                "Introduction to Entrepreneurship",
                "Calculus",
                "Mobile applications",
                "Basics of Computer Networking",
                "Python",
                "Principles of digital technology",
                5
        )
        questionList.add(question5)

        //6
        val question6 = Questions(
                6,
                "What subject does this person teach us?",
                R.drawable.batonigamdlishvili,
                "Introduction to Entrepreneurship",
                "Calculus",
                "Mobile applications",
                "Basics of Computer Networking",
                "Python",
                "Principles of digital technology",
                1
        )
        questionList.add(question6)

        return questionList




    }


}