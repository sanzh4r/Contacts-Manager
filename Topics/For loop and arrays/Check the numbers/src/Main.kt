fun main() {
    // Read the size of the array
    val n = readLine()!!.toInt()

    // Read the elements of the array
    val array = IntArray(n) { readLine()!!.toInt() }

    // Read p and m
    val (p, m) = readLine()!!.split(" ").map { it.toInt() }

    // Check if p and m never occur next to each other
    val result = checkIfNotAdjacent(array, p, m)

    // Print the result
    println(result)
}

fun checkIfNotAdjacent(array: IntArray, p: Int, m: Int): String {
    for (i in 0 until array.size - 1) {
        if ((array[i] == p && array[i + 1] == m) || (array[i] == m && array[i + 1] == p)) {
            return "NO"
        }
    }
    return "YES"
}