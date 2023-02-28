import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")


    var num = 0
    do{
        var rnd = (0..9).shuffled().take(4).joinToString("")
        num = rnd as Int
    }while ((rnd as Int) < 1000);






    var userNum = readln();

    println("$num---$userNum")






}