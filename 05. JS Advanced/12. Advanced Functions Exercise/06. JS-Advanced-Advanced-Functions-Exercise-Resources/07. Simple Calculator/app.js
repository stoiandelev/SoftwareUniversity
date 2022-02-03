function calculator() {
    let number1;
    let number2;
    let resultBox;

    function init(selector1, selector2, selector3) {
        number1 = document.querySelector(selector1);
        number2 = document.querySelector(selector2);
        resultBox = document.querySelector(selector3);
        console.log(number1, number2, resultBox);
    }

    function add() {
        resultBox.value = Number(number1.value) + Number(number2.value);
    }

    function subtract() {
        resultBox.value = Number(number1.value) - Number(number2.value);
    }

    return {
        init,
        add,
        subtract
    }
}


const calculate = calculator();
calculate.init('#num1', '#num2', '#result');





