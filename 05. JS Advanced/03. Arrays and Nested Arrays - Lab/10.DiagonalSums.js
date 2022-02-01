function diagonalSums(arr) {
    let sum1 = 0;
    let sum2 = 0;
    const size = arr.length - 1;

    for (let i = 0; i < arr.length; i++) {
        sum1 += arr[i][i];
        sum2 += arr[i][size - i];
    }
    console.log(`${sum1} ${sum2}`)
}

diagonalSums([[20, 40],
    [10, 60]]
)