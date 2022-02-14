const {expect, assert} = require("chai");
const logic = require("./testNumbers");
const {testNumbers} = require("./testNumbers");

describe("Test login", () => {

    it("Test sum functionality", () => {
        expect(testNumbers.sumNumbers(1, "1")).to.be.undefined;
    })

    it("Test sum functionality", () => {
        expect(testNumbers.sumNumbers(-1, 1)).to.equal("0.00");

    })

    it("Test sum functionality", () => {
        expect(testNumbers.sumNumbers("a", 1)).to.be.undefined;
    })


    it("Test checker functionality", () => {
        expect(testNumbers.numberChecker(1)).to.contain("odd");
        expect(testNumbers.numberChecker(0)).to.contain("even");
        expect(testNumbers.numberChecker(2)).to.contain("even");
        expect(testNumbers.numberChecker.bind("str")).to.throw("The input is not a number!");

    })

    it("Test sum averageFromArray", () => {
        expect(testNumbers.averageSumArray([1, 2, 3, 4])).to.equals(2.5);
    })

})