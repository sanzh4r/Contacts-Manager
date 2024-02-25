import java.util.*

fun parsingNickname(emailString: String): String {
    val symbolsForNickname = Regex("[._]")
    val nicknameString = emailString.split("@").first()
    val (firstName, lastName ) = nicknameString.split(symbolsForNickname)
    val nickname = "$firstName $lastName".split(" ").joinToString(" ") {it.capitalize()}
    return nickname
}