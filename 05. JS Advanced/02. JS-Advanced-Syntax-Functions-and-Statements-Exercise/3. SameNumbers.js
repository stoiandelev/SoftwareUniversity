function sameNumbers(input) {
    const stringNum = input.toString();

    let result = parseInt(stringNum[0]);
    let isSame = true;

    for (let i = 1; i < stringNum.length; i++) {
        result += parseInt(stringNum[i]);

        if (stringNum[i] !== stringNum[i - 1]) {
            isSame = false;
        }
    }
    console.log(isSame);
    console.log(result);
}

sameNumbers(1234)