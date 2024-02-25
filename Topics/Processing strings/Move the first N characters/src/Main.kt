fun main() {
    var (s, n) = readln().toString().split(" ")
    if (n.toInt() == s.length || n.toInt() > s.length) {
        println(s)
    } else {
        println(s.substring(n.toInt()) + s.substring(0, n.toInt()))
    }
}
