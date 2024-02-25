fun main() {
    val text = readln()
    val newText = text.replace("[aA]+".toRegex(), "a")
    println(newText)
}
