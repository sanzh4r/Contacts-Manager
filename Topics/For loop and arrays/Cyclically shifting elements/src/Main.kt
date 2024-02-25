fun main() {
    val number = readln().toInt()
    val array = IntArray(number)

    for (i in 0..array.lastIndex) {
        array[i] = readln().toInt()
    }

    print(array.last().toString() + " ")

    for (i in 0 until array.lastIndex) {
        print(array[i].toString() + " ")
    }
}
