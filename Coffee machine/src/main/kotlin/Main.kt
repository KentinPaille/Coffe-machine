fun main() {
    var exit = false
    var data = arrayListOf(0,0,0,0,0)
    var money = 10
    var result = Pair(data, money)

    while (!exit) {
        println("You have ${money}$")
        println("Write action (buy, fill, take, remaining, exit):")
        when (readLine()) {
            "exit" -> exit = true
            "remaining" -> remaining(data)
            "buy" -> result = buy(data, money)
            "fill" -> data = fill(data)
            "take" -> data = take(data)
            else -> println("Put an action please.\n")
        }
        data = result.first
        money = result.second
    }
}

fun take(data: ArrayList<Int>):ArrayList<Int> {
    println("You have: water, milk, coffee beans, disposable cups, money")
    println("What do you want to take ?")
    when(readLine()) {
        "water" -> data[0] = takedata(data[0])
        "milk" -> data[1] = takedata(data[1])
        "coffee beans" -> data[2] = takedata(data[2])
        "disposable cups" -> data[3] = takedata(data[3])
        "money" -> data[4] = takedata(data[4])
        else -> return (take(data))
    }
    println("You leave the take")
    return (data)
}

fun takedata(quantity:Int):Int {
    println("You have ${quantity} of quantity")
    println("How much do you want to take it ?")
    val out = readLine()?.toIntOrNull()
    if (out == null) {
        println("Please enter a number")
        return (filldata(quantity))
    }
    if (out > quantity) {
        println("You don't have this quantity")
        while (true) {
            println("Would you 'retry' or 'exit' ?")
            when (readLine()) {
                "exit" -> return (quantity)
                "retry" -> takedata(quantity)
                else -> println("Put good action please")
            }
        }
    }
    println("You have removed\n ${out}\n")
    return (quantity - out)
}

fun fill(data: ArrayList<Int>):ArrayList<Int> {
    println("You have: water, milk, coffee beans, disposable cups, money")
    println("What do you want to fill ?")
    when(readLine()) {
        "water" -> data[0] = filldata(data[0])
        "milk" -> data[1] = filldata(data[1])
        "coffee beans" -> data[2] = filldata(data[2])
        "disposable cups" -> data[3] = filldata(data[3])
        "money" -> data[4] = filldata(data[4])
        else -> return (fill(data))
    }
    println("You leave the fill\n")
    return (data)
}

fun filldata(quantity:Int):Int {
    println("How much do you want to fill it ?")
    val out = readLine()?.toIntOrNull()
    if (out == null) {
        println("Please enter a number")
        return (filldata(quantity))
    }
    println("You have add ${out}.")
    return (quantity + out)
}

fun buy(data: ArrayList<Int>, money:Int):Pair<ArrayList<Int>, Int> {
    var result: Pair<ArrayList<Int>, Int> = Pair(data, money)
    println("What do you want to buy ? 1 - espresso:3e , 2 - latte:4e , 3 - cappuccino:3e , 4 - exit:")
    when (readLine()) {
        "1" -> result = espresso(data, money)
        "espresso" -> result = espresso(data, money)
        "2" -> result = latte(data, money)
        "latte" -> result = latte(data, money)
        "3" -> result = cappuccino(data, money)
        "cappuccino" -> result = cappuccino(data, money)
        "exit" -> println("You don't have take coffee")
        "4" -> println("You don't have take coffee")
        else -> return (buy(data, money))
    }
    println("\n")
    return Pair(result.first, result.second)
}

fun espresso(data: ArrayList<Int>, money:Int):Pair<ArrayList<Int>, Int> {
    if (money < 3)  {
        println("You don't have enough money, please add money for retry")
        return Pair(data, money)
    } else if (data[0] < 5) {
        println("We don't have enough water, please try an other")
        return Pair(data, money)
    } else if (data[2] < 5) {
        println("We don't have enough coffee, please call assistance")
        return Pair(data, money)
    } else if (data[3] == 0) {
        println("We don't have enough disposable cup, please call assistance")
        return Pair(data, money)
    } else {
        data[0] -= 5
        data[2] -= 5
        data[3] -= 1
        data[4] += 3
    }
    println("Thank you")
    return Pair(data, money - 3)
}

fun latte(data: ArrayList<Int>, money:Int):Pair<ArrayList<Int>, Int> {
    if (money < 4)  {
        println("You don't have enough money, please add money for retry")
        return Pair(data, money)
    } else if (data[1] < 15) {
        println("We don't have enough milk, please try an other")
        return Pair(data, money)
    } else if (data[2] < 5) {
        println("We don't have enough coffee, please call assistance")
        return Pair(data, money)
    } else if (data[3] == 0) {
        println("We don't have enough disposable cup, please call assistance")
        return Pair(data, money)
    } else {
        data[1] -= 15
        data[2] -= 5
        data[3] -= 1
        data[4] += 4
    }
    println("Thank you")
    return Pair(data, money - 4)
}

fun cappuccino(data: ArrayList<Int>, money:Int):Pair<ArrayList<Int>, Int> {
    if (money < 3)  {
        println("You don't have enough money, please add money for retry")
        return Pair(data, money)
    } else if (data[0] < 10) {
        println("We don't have enough water, please try an other")
        return Pair(data, money)
    } else if (data[2] < 10) {
        println("We don't have enough coffee, please try an other")
        return Pair(data, money)
    } else if (data[3] == 0) {
        println("We don't have enough disposable cup, please call assistance")
        return Pair(data, money)
    } else {
        data[1] -= 10
        data[2] -= 10
        data[3] -= 1
        data[4] += 3
    }
    println("Thank you")
    return Pair(data, money - 3)
}

fun remaining(data: ArrayList<Int>) {
    println("\nThe coffee machine has:")
    println("${data[0]}ml of water")
    println("${data[1]}ml of milk")
    println("${data[2]} of coffee beans")
    println("${data[3]} of disposable cups")
    println("${data[4]}$ of money\n")
}