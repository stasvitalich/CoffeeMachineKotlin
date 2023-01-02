const val action = "Write action (buy, fill, take, remaining, exit): "

const val buyText = "\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "
const val enoughResources = "I have enough resources, making you a coffee!\n"
const val waterShortage = "Sorry, not enough water!\n"
const val milkShortage = "Sorry, not enough milk!\n"
const val coffeeBeansShortage = "Sorry, not enough milk!\n"
const val cupsShortage = "Sorry, not enough cups!\n"

const val fillWater = "\nWrite how many ml of water you want to add: "
const val fillMilk = "Write how many ml of milk you want to add: "
const val fillCoffeeBeans = "Write how many grams of coffee beans you want to add: "
const val fillCups = "Write how many disposable cups you want to add: "

const val takeText = "I gave you $"

const val remaining = "\nThe coffee machine has:"
const val remainingWater = "ml of water"
const val remainingMilk = "ml of milk"
const val remainingCoffeeBeans = "g of coffee beans"
const val remainingCups = "disposable cups"
const val remainingMoney = "of money\n"

var initialWater = 400
var initialMilk = 540
var initialCoffeeBeans = 120
var initialCups = 9
var initialMoney = 550


class Coffee {
    fun makeEspresso() {
        if (initialWater >= 250 &&
            initialCoffeeBeans >= 16 &&
            initialCups >= 1
        ) {
            println(enoughResources)
            initialWater -= 250
            initialCoffeeBeans -= 16
            initialCups -= 1
            initialMoney += 4
        } else if (initialWater < 250) {
            println(waterShortage)
        } else if (initialCoffeeBeans < 16) {
            println(coffeeBeansShortage)
        } else if (initialCups < 1) {
            println(cupsShortage)
        }
    }

    fun makeLatte() {
        if (initialWater >= 350 &&
            initialMilk >= 75 &&
            initialCoffeeBeans >= 20 &&
            initialCups >= 1
        ) {
            println(enoughResources)
            initialWater -= 350
            initialMilk -= 75
            initialCoffeeBeans -= 20
            initialCups -= 1
            initialMoney += 7
        } else if (initialWater < 350) {
            println(waterShortage)
        } else if (initialMilk < 75) {
            println(milkShortage)
        } else if (initialCoffeeBeans < 20) {
            println(coffeeBeansShortage)
        } else if (initialCups < 1) {
            println(cupsShortage)
        }
    }

    fun makeCappuccino() {
        if (initialWater >= 200 &&
            initialMilk >= 100 &&
            initialCoffeeBeans >= 12 &&
            initialCups >= 1
        ) {
            println(enoughResources)
            initialWater -= 200
            initialMilk -= 100
            initialCoffeeBeans -= 12
            initialCups -= 1
            initialMoney += 6
        } else if (initialWater < 200) {
            println(waterShortage)
        } else if (initialMilk < 100) {
            println(milkShortage)
        } else if (initialCoffeeBeans < 12) {
            println(coffeeBeansShortage)
        } else if (initialCups < 1) {
            println(cupsShortage)
        }
    }
}

class YourChoice {

    fun buy() {
        println(buyText)
    }

    fun fillWater() {
        println(fillWater)
        var additionalWater = readln().toInt()
        initialWater += additionalWater
    }

    fun fillMilk() {
        println(fillMilk)
        var additionalMilk = readln().toInt()
        initialMilk += additionalMilk
    }

    fun fillCoffeeBeans() {
        println(fillCoffeeBeans)
        var additionalCoffeeBeans = readln().toInt()
        initialCoffeeBeans += additionalCoffeeBeans
    }

    fun fillCups() {
        println(fillCups)
        var additionalCups = readln().toInt()
        initialCups += additionalCups
    }

    fun fill() {
        fillWater()
        fillMilk()
        fillCoffeeBeans()
        fillCups()
    }

    fun take() {
        println("$takeText$initialMoney\n")
        initialMoney = initialMoney - initialMoney
    }

    fun remaining() {
        println(remaining)
        println("$initialWater $remainingWater")
        println("$initialMilk $remainingMilk")
        println("$initialCoffeeBeans $remainingCoffeeBeans")
        println("$initialCups $remainingCups")
        println("$$initialMoney $remainingMoney")
    }
}

fun main() {

    var typeOfCoffee = Coffee()
    var yourChoice = YourChoice()

    do {
        println(action)
        var yourAction = readln()

        if (yourAction == "buy") {
            yourChoice.buy()
            var yourPurchase = readln()
            if (yourPurchase == "1") {
                typeOfCoffee.makeEspresso()
            } else if (yourPurchase == "2") {
                typeOfCoffee.makeLatte()
            } else if (yourPurchase == "3") {
                typeOfCoffee.makeCappuccino()
            } else if (yourPurchase == "back") {
                println("")
            }
        }

        if (yourAction == "fill") {
            yourChoice.fill()
        }
        if (yourAction == "take") {
            yourChoice.take()
        }
        if (yourAction == "remaining") {
            yourChoice.remaining()
        }

    } while (yourAction != "exit")
}
