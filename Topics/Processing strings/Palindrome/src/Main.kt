fun main() {
    val str = readln().toString()
    var forward = ""
    var backward = ""

    for (i in 0..str.lastIndex) {
        forward += str[i]
    }

    for (u in str.lastIndex downTo 0) {
        backward += str[u]
    }

    if (forward == backward) {
        println("yes")
    } else {
        println("no")
    }

}
