package ipv4_checker

fun main() {

}

fun isValidIPv4Address(input: String): Boolean {
    val segments = input.split(".")
    if (segments.size != 4) return false

    for (segment in segments) {
        if (segment.isEmpty() ||
           (segment.length > 1 && segment.startsWith("0")) ||
           ((segment.toIntOrNull() ?: return false) !in 0..255)
        ) return false
    }
    return true
}






