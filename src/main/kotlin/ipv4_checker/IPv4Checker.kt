package ipv4_checker

fun main() {

    println(isValidIPv4Address("192.1#8.1.1"))      // false
    println(isValidIPv4Address("192.168.1"))        // false
    println(isValidIPv4Address("192.168.1.1"))      // true
    println(isValidIPv4Address("256.256.256.256"))  // false
    println(isValidIPv4Address("192.168.1.1.1"))    // false
    println(isValidIPv4Address("0.0.0.0"))          // true
    println(isValidIPv4Address("192.168.01.1"))     // false
    println(isValidIPv4Address("192.168.1.a"))      // false
    println(isValidIPv4Address("255.255.255.255"))  // true
    println(isValidIPv4Address("192.168*1.a"))      // false

}



fun isValidIPv4Address(input: String): Boolean {
    return false
}







