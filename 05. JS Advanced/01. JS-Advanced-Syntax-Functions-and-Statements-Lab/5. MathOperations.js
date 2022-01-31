function mathOperations(number1, number2, operation) {
    //The string may be one of the following: '+', '-', '*', '/', '%', '**'.
    let result = 0;
    switch (operation) {
        case "+":
            result = number1 + number2;
            break;
        case "-":
            result = number1 - number2;
            break;
        case "*":
            result = number1 * number2;
            break;
        case "/":
            result = number1 / number2;
            break;
        case "%":
            result = number1 % number2;
            break;
        case "**":
            result = number1 ** number2
            break;
        default:
            console.log("Invalid Operation")
    }
    console.log(result)
}

mathOperations(3, 5.5, '*');
