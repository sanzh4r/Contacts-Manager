fun main() {
    val line = readln().toString()
    val first = line[0]
    val last = line.last()
    println(line.substring(0, line.lastIndex).replace(first, last) + first)
}