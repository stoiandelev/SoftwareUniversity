function stringLength(firstString, secondString, thirdString) {
    let sumLength = firstString.length + secondString.length + thirdString.length;
    let averageLength = Math.round(sumLength / 3);
    console.log(sumLength);
    console.log(averageLength)
}

stringLength('pasta', '5', '22.3')