
function greatestCommonDivisorGCD(a, b) {
    while (b !== 0) {
        const temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

greatestCommonDivisorGCD(	2154, 458);
