function biggestElement(matrix) {
    let biggestElement = Number.NEGATIVE_INFINITY;
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] >= biggestElement) {
                biggestElement = matrix[i][j];
            }
        }
    }
    console.log(biggestElement);
}

biggestElement(
    [[20, 50, 10],
        [8, 33, 145]]
)