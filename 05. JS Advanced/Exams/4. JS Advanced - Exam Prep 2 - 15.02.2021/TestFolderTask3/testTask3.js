let {expect} = require("chai");
let {testTask3, dealership} = require("./Taks3");


describe("Test dealerShip", function () {
    it("new car cost", function () {
        expect(dealership.newCarCost("Audi A4",100000)).to.equals(100000);
        expect(dealership.newCarCost("Audi A4",1200.56)).to.equals(1200.56);
        expect(dealership.newCarCost("Audi A6 4K",100000)).to.equals(80000);
        expect(dealership.newCarCost("Audi A8 D5",100000)).to.equals(75000);
    });
    it("carEquipment", function () {
        expect(dealership.carEquipment(["ex1","ex2","ex3"],[0,1,2])).to.deep.equals(["ex1","ex2","ex3"]);
        expect(dealership.carEquipment(["ex1","ex2","ex3"],[0,1])).to.deep.equals(["ex1","ex2"]);
        expect(dealership.carEquipment(["ex1","ex2","ex3"],[0])).to.deep.equals(["ex1"]);
    });
    it("euroCategory", function () {
        expect(dealership.euroCategory(4)).to.equals("We have added 5% discount to the final price: 14250.");
        expect(dealership.euroCategory(5)).to.equals("We have added 5% discount to the final price: 14250.");
        expect(dealership.euroCategory(6)).to.equals("We have added 5% discount to the final price: 14250.");
        expect(dealership.euroCategory(3)).to.equals("Your euro category is low, so there is no discount from the final price!");
        expect(dealership.euroCategory(2)).to.equals("Your euro category is low, so there is no discount from the final price!");
    });
});



