fun main() {
    val text = readLine()!!
    val regexColors = "#[0-9a-fA-F]{6}\\b".toRegex()

    val matchResult =
    regexColors.findAll(text)
    for (matches in matchResult) println(matches.value)
}
