fun main() {
    val nNumber = readln().toInt()
    val array = IntArray(nNumber)

    for (i in 0..array.lastIndex) {
        array[i] = readln().toInt()
    }
    
    val mNumber = readln().toInt()

    if (array.contains(mNumber)) {
        println("YES")
    } else {
        println("NO")
    }
}
