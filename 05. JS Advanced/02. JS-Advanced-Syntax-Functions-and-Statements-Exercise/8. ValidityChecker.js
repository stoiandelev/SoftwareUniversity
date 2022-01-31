function validityChecker(x1, y1, x2, y2) {
    const isValid = (x1, y1, x2, y2) => Math.sqrt((y2 - y1) ** 2 + (x2 - x1) ** 2) % 1 === 0 ? 'valid' : 'invalid';
    const print = (x1, y1, x2, y2) => console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${isValid(x1, y1, x2, y2)}`);
    print(x1, y1, 0, 0);
    print(x2, y2, 0, 0);
    print(x1, y1, x2, y2);
}

validityChecker(3, 0, 0, 4)