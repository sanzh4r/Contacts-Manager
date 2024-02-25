fun main() {
    val s = readln().toString()
    if (s.length > 0) {
        var counter = 1
        for (i in 0 until s.length - 1) {
            if (s[i] == s[i+1]) {
                ++counter
            } else {
                print("${s[i]}$counter")
                counter = 1
            }
        }
        print("${s.last()}$counter")
    }
}