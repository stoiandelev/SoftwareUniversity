function processOddPositions(arr) {
    //всяко нечетно с филтър
    //умножи всяко от филтрираните числа по две
    //завърти ги
    //събери ги
    return arr.filter((a, i) => i % 2 !== 0)
        .map(x => x * 2)
        .reverse()
        .join(" ")
}

processOddPositions([10, 15, 20, 25])