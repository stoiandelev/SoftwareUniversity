let {expect} = require("chai");
let {numberOperations} = require("./03. Number Operations_Resources")


describe("test for numbers", function () {
    it("powNumber", function () {
        expect(numberOperations.powNumber(2)).to.equals(4);
        expect(numberOperations.powNumber(2.5)).to.equals(6.25);
    });
    it("NumberChecker", function () {
        expect(numberOperations.numberChecker.bind("a")).to.throw('The input is not a number!');
        expect(numberOperations.numberChecker.bind("")).to.throw('The input is not a number!');
        expect(numberOperations.numberChecker(10)).to.equals('The number is lower than 100!');
        expect(numberOperations.numberChecker(99)).to.equals('The number is lower than 100!');
        expect(numberOperations.numberChecker(101)).to.equals('The number is greater or equal to 100!');
        expect(numberOperations.numberChecker(150)).to.equals('The number is greater or equal to 100!');
        expect(numberOperations.numberChecker(100)).to.equals('The number is greater or equal to 100!');
    });
    it("SumArr", function () {
        expect(numberOperations.sumArrays([], [])).to.deep.equals([]);
        expect(numberOperations.sumArrays([1, 2], [1, 2])).to.deep.equals([2, 4]);
        expect(numberOperations.sumArrays([1, 2, 3], [1, 2])).to.deep.equals([2, 4, 3]);
        expect(numberOperations.sumArrays([1, 2], [1, 2,3])).to.deep.equals([2, 4, 3]);
        expect(numberOperations.sumArrays([1.1, 2.2], [1.1, 2.2])).to.deep.equals([2.2, 4.4]);
    });
});

