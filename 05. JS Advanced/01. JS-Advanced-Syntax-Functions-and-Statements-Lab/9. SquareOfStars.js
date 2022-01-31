function squareOfStars(input) {
    let n = Number(input);

    for (let i = 1; i <= n; i++) {
        let printLine = "";
        for (let j = 1; j <= n; j++) {
            printLine += "* ";
        }
        console.log(printLine);
    }
}
squareOfStars(3)