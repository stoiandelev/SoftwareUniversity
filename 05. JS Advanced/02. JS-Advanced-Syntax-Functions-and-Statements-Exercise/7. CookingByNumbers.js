function cookingByNumbers(number, oper1, oper2, oper3, oper4, oper5) {

    number = Number(number);

    let chop = function (n) {
        return n / 2;
    }
    let dice = function (n) {
        return Math.sqrt(n);
    }
    let spice = function (n) {
        return n + 1;
    }
    let bake = function (n) {
        return n * 3;
    }
    let fillet = function (n) {
        return n * 0.8;
    }

    const arr = [oper1, oper2, oper3, oper4, oper5];
    // резултата ни е равен на първото число
    let result = number;

    //Обхождаме всички оператори в масива
    for (let i = 0; i < arr.length; i++) {
        switch (arr[i]) {
            case "chop":
                //викаме функцията да ги изчисли
                result = chop(result);
                console.log(result);
                break;
            case "dice":
                result = dice(result);
                console.log(result);
                break;
            case "spice":
                result = spice(result);
                console.log(result);
                break;
            case "bake":
                result = bake(result);
                console.log(result);
                break;
            case "fillet":
                result = fillet(result);
                console.log(result);
                break;
        }
    }
}

cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet')

