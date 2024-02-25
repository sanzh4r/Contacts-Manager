fun main() {
    val string = readln().toString()
    var firstHalf = 0
    var secondHalf = 0
    for (i in string.substring(0, 3)) {
        firstHalf += i.toString().toInt()
    }
    for (u in string.substring(3, 6)) {
        secondHalf += u.toString().toInt()
    }
    if (firstHalf == secondHalf) {
        println("Lucky")
    } else {
        println("Regular")
    }
}