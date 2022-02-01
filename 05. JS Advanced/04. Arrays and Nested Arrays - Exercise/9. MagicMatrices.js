function magicMatrices(matrix) {
    let value = sum(matrix[0]);
    let equal = true;

    for (let row = 1; row < matrix.length; row++) {
        if (value !== sum(matrix[row])) {
            equal = false;
            break;
        }
    }

    for (let col = 0; col < matrix[0].length; col++) {
        if (value !== sum(creatingArray(matrix, col))) {
            equal = false;
            break;
        }
    }

    if (equal) {
        return true;
    } else {
        return false;
    }

    function creatingArray(matrix, col) {
        let array = [];
        for (let row = 0; row < matrix.length; row++) {
            array.push(matrix[row][col]);
        }
        return array;
    }

    function sum(matrix) {
        return matrix.reduce((acc, el) => {
            return acc + el;
        });

    }
}

magicMatrices([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]

)