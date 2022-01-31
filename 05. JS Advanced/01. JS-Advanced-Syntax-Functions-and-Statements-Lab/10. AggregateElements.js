function aggregateElements(input) {
    let result1 = 0;
    let result2 = 0;
    let result3 = '';
    for(let el of input) {
        result1 += Number(el)
        result2 += Number(1/el)
        result3 += el
    }

    console.log(result1);
    console.log(result2);
    console.log(result3);

}

aggregateElements([1, 2, 3])