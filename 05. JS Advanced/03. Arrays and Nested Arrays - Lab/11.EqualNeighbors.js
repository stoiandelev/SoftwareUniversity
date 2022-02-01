function equalNeighbors(arr) {
    let counter = 0;
    for (let i = 0; i < arr.length; i++) {
        let row = arr[i];
        for (let j = 0; j < row.length; j++) {
            let col = row[j];

            if (i !== arr.length - 1) {
                if (col === row[j + 1]) {
                    counter++;
                }
                if (col === arr[i + 1][j]) {
                    counter++;
                }
            } else if (col === row[j + 1] || col === arr[i][j + 1]) {
                counter++;
            }
        }
    }
    console.log(counter);
}
equalNeighbors([['test', 'yes', 'yo', 'ho'],
    ['well', 'done', 'yo', '6'],
    ['not', 'done', 'yet', '5']]
)