fun main() {
    val number = readln()
    val regexNumber = Regex("[a-zA-Z]+")
    println(regexNumber.replace(number, ""))
}