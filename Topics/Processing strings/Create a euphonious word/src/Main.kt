fun main() {
    val str = readln().toString()
    val setVowels = setOf('a','e','i','o','u','y')
    var vowels = 0
    var consonants = 0
    var addition = 0

    for (i in str) {
        if (setVowels.contains(i)) {
            vowels++
            consonants = 0
        } else {
            consonants++
            vowels = 0
        }
        if (vowels >= 3 || consonants >= 3) {
            addition++
            vowels = 1
            consonants = 1
        }
    }
    print(addition)
}