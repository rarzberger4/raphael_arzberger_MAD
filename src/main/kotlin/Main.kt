import kotlin.random.Random
fun checkStrongMatch(rndNum: Int, userNum: Int): Int {
    var rnd = rndNum
    var usr = userNum
    var hardMatch = 0
    var softMatch = 0
    var round = 1

    var digitsRnd = mutableListOf<Int>()
    var digitsUsr = mutableListOf<Int>()

    do{
        var fDigRnd = firstDigit(rnd)
        var fDigUsr = firstDigit(usr)
        if(fDigUsr == fDigRnd){
            hardMatch++
        }

        digitsRnd.add(fDigRnd)
        digitsUsr.add(fDigUsr)

        rnd %= (10000 / (pow(10, round)))  //cuts the first digit each round
        usr %= (10000 / (pow(10, round)))

        round++
    }while(usr >= 1)



    digitsRnd.forEach{
        for (i in digitsUsr) {
            if (i == it){
                softMatch++
            }
        }
    }

    println("Hardmatches: $hardMatch ____ Softmatches: $softMatch")
    return 0
}

fun firstDigit(n: Int): Int{
    var ret = n;
    while(ret > 10){      //gets the first digit of a number
        ret /= 10;
    }
    return ret;
}
fun checkWeakMatch(): Int {

    return 0;
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


fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")


    var num = 0
    do {
        var rnd = (0..9).shuffled().take(4).joinToString("")
        num = rnd.toInt()
    } while (num < 1000)

    num = 1234
    println("Guess a number: ")
    var userNum = readln().toInt()



    var result = checkStrongMatch(num as Int, userNum as Int)

    println("$num---$userNum --> $result")




}