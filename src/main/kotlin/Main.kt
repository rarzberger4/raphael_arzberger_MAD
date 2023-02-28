fun checkMatches(rndNum: Int, userNum: Int): Boolean{
    var rnd = rndNum
    var usr = userNum
    var hardMatch = 0
    var softMatch = 0
    var round = 1

    val digitsRnd = mutableListOf<Int>()    //lists the digits of a number
    val digitsUsr = mutableListOf<Int>()

    do{     // get every digit of both numbers, add them to the lists and check for hardMatches
        val fDigRnd = firstDigit(rnd)
        val fDigUsr = firstDigit(usr)
        if(fDigUsr == fDigRnd){
            hardMatch++
        }

        digitsRnd.add(fDigRnd)
        digitsUsr.add(fDigUsr)

        rnd %= (10000 / (pow(10, round)))  //cuts the first digit each round
        usr %= (10000 / (pow(10, round)))

        round++
    }while(usr >= 1)


            //check digit lists for softMatches
    val found = mutableListOf<Int>()

    digitsRnd.forEach{
        for (i in digitsUsr) {
            if (i == it){
                if(!found.contains(i)){
                    found.add(i)
                    softMatch++
                }
            }
        }
    }

    println("$softMatch:$hardMatch")
    return (softMatch + hardMatch) == 8
}
fun firstDigit(n: Int): Int{
    var ret = n
    while(ret > 10){      //gets the first digit of a number
        ret /= 10
    }
    return ret
}
fun pow(num: Int, exp: Int): Int{
    var expo = exp
    var result: Long = 1
    while (expo != 0) {
        result *= num.toLong()
        --expo
    }
    return result.toInt()
}
fun celebrate(){
        println("**************************************")
        println("*                                    *")
        println("*           CONGRATULATIONS!         *")
        println("*                                    *")
        println("*         ___________                *")
        println("*        '._==_==_=_.'               *")
        println("*        .-\\:      /-.               *")
        println("*       | (|:.     |) |              *")
        println("*        '-|:.     |-'               *")
        println("*          \\::.    /                 *")
        println("*           '::. .'                  *")
        println("*             ) (                    *")
        println("*           _.' '._                  *")
        println("*          '-------'                 *")
        println("*                                    *")
        println("*      You have completed the game!  *")
        println("*      Thank you for playing!        *")
        println("*                                    *")
        println("**************************************")
}

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")


    var num: Int
    do {
        val rnd = (0..9).shuffled().take(4).joinToString("")
        num = rnd.toInt()
    } while (num < 1000)

    //println("random number: $num")
    do{
        var userNum = 0
        do {
            println("Guess the 4 digit number: ")
            try{
                userNum = readln().toInt()
            }catch(e: Exception){
                println("No Input!")
            }
        }while(userNum < 1000)
    }while (!checkMatches(num, userNum))

    println("You Won!")
    celebrate()

}