function printEveryNThElementFromAnArray(array, step) {

    const result = [];
    for (let i = 0; i < array.length; i += step) {
        result.push(array[i]);
    }
    return result;
}

printEveryNThElementFromAnArray(['1',
        '2',
        '3',
        '4',
        '5'],
    6
)

