let {expect} = require("chai");
let {pizzUni} = require("./Task3");


describe("testPizza", function () {
    let noDrink = {orderedPizza: 'pizza'};
    let noPizza = {orderedDrink: 'cola'};
    let correctOrder = {orderedPizza: 'pizza', orderedDrink: 'cola'};
    let noPizzaNoDrink = {};

    it("make it Order", function () {
        expect(pizzUni.makeAnOrder(noDrink)).to.equals("You just ordered pizza");
        expect(pizzUni.makeAnOrder(correctOrder)).to.equals("You just ordered pizza and cola.");
        expect(() => pizzUni.makeAnOrder(noPizza)).to.throw("You must order at least 1 Pizza to finish the order.")
        expect(() => pizzUni.makeAnOrder(noPizzaNoDrink)).to.throw("You must order at least 1 Pizza to finish the order.")
    });

    it("getRemainingWork", function () {
        let status = [
            {pizzaName: "margarita", status: "ready"},
            {pizzaName: "jons", status: "ready"}
        ]

        let status1 = [
            {pizzaName: "margarita", status: "ready"},
            {pizzaName: "jons", status: "preparing"},
            {pizzaName: "jonatan", status: "preparing"}
        ]
        expect(pizzUni.getRemainingWork(status1)).to
            .equals("The following pizzas are still preparing: jons, jonatan.")
        expect(pizzUni.getRemainingWork(status)).to
            .equals("All orders are complete!")

    });

    it("orderType", function () {
        expect(pizzUni.orderType(10,"Delivery")).to.equals(10)
        expect(pizzUni.orderType(10.5,"Delivery")).to.equals(10.5)
        expect(pizzUni.orderType(10,"Carry Out")).to.equals(9)
        expect(pizzUni.orderType(10.5,"Carry Out")).to.equals(9.45)
    });

});



