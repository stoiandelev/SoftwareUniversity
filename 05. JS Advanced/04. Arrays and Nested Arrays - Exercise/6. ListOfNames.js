function listOfNames(arr) {
    const result = arr.sort((a, b) => a.localeCompare(b));
    let number = 1;
    arr.forEach((el) => {
        console.log(`${number}.${el}`);
        number++;
    });
}

listOfNames(["John", "Bob", "Christina", "Ema"])