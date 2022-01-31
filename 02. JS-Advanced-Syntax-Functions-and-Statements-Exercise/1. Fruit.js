/**
 *  -> JS DOC
 * @param fruit
 * @param weight
 * @param money
 * @author Stoyan Delev
 */

function calculateNeedMoney(fruit, weight, money) {
    const gramToKg = weight / 1000;
    const totalPrice = gramToKg * money
    console.log(`I need $${totalPrice.toFixed(2)} to buy ${gramToKg.toFixed(2)} kilograms ${fruit}.`)
}

calculateNeedMoney('orange', 2500, 1.80)


