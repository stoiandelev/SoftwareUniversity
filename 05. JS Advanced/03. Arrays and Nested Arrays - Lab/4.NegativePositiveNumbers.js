function negativePositiveNumbers(arr) {
    const result = [];

    for (const num of arr) {
        if (num < 0) {
            result.unshift(num)
        } else {
            result.push(num)
        }
    }

    for (const resultElement of result) {
        console.log(resultElement)
    }

}

negativePositiveNumbers([3, -2, 0, -1])