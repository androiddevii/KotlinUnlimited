package ipv4_checker

fun main() {

    test(
        name = "when given an IPv4 address containing an invalid character, then return false",
        result = isValidIPv4Address("192.1#8.1.1"),
        correctResult = false
    )

    test(
        name = "when given an IPv4 address with less than four segments, then return false",
        result = isValidIPv4Address("192.168.1"),
        correctResult = false
    )

    test(
        name = "when given an IPv4 address has more than four segments, then return false",
        result = isValidIPv4Address("192.168.1.1.1"),
        correctResult = false
    )

    test(
        name = "when given a valid IPv4 address with four segments and no leading zeros, then return true",
        result = isValidIPv4Address("192.168.1.1"),
        correctResult = true
    )

    test(
        name = "when given an IPv4 address with a segment out of range (greater than 255), then return false",
        result = isValidIPv4Address("256.256.256.256"),
        correctResult = false
    )

    test(
        name = "when given a valid IPv4 address consisting of four zero segments, then return true",
        result = isValidIPv4Address("0.0.0.0"),
        correctResult = true
    )

    test(
        name = "when given an IPv4 address containing a leading zero in any segment, then return false",
        result = isValidIPv4Address("192.168.01.1"),
        correctResult = false
    )

    test(
        name = "when given an IPv4 address containing a non-numeric character, then return false",
        result = isValidIPv4Address("192.168.1.a"),
        correctResult = false
    )

    test(
        name = "when given a valid IPv4 address within the acceptable range, then return true",
        result = isValidIPv4Address("255.255.255.255"),
        correctResult = true
    )

    test(
        name = "when given an IPv4 address that does not contain exactly three dots, then return false",
        result = isValidIPv4Address("192.168*1.a"),
        correctResult = false
    )

    test(
        name = "when given an IPv4 address has an empty segment, then return false",
        result = isValidIPv4Address("192..168.1.1"),
        correctResult = false
    )

    test(
        name = "when given an IPv4 address contains spaces, then return false",
        result = isValidIPv4Address("192. 168.1.1"),
        correctResult = false
    )

    test(
        name = "when given an IPv4 address contains a negative number, then return false",
        result = isValidIPv4Address("-1.168.1.1"),
        correctResult = false
    )
}


fun test(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}
