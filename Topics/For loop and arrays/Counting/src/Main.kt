fun main() {
    val n = readln().toInt()
    val array = IntArray(n)

    for (num in 0..array.lastIndex) {
        array[num] = readln().toInt()
    }

    val m = readln().toInt()

    var counter = 0

    for (index in array) {
        if (index == m) {
            ++counter
        }
    }

    println(counter)

}