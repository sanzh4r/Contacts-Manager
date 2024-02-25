fun getCamelStyleString(inputString: String): String {
    val outputString = inputString.split("_")
    var result = ""
    for (word in outputString) {
        result += word.capitalize()
    }
    return result
}