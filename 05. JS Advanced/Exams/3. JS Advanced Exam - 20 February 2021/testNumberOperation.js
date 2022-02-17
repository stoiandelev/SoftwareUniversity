let {expect} = require("chai");
let {numberOperations} = require("./numberOperations")

describe("Tests NumberOperation", function () {

    describe("PowNumber", function () {
        it("Correct input", function () {
            expect(numberOperations.powNumber(3)).to.equals(9);
        });
    });


    describe("numberChecker", function () {
        it("Incorrect Input", function () {
            expect(numberOperations.numberChecker.bind("asd")).to.throw('The input is not a number!');
        });

        it("Incorrect Input", function () {
            expect(numberOperations.numberChecker.bind("#4")).to.throw('The input is not a number!');
        });

        it("Lower then 100", function () {
            expect(numberOperations.numberChecker(2)).to.equals("The number is lower than 100!");
        });

        it("Lower then 100", function () {
            expect(numberOperations.numberChecker(100)).to.equals("The number is greater or equal to 100!");
        });

        it("Lower then 100", function () {
            expect(numberOperations.numberChecker(101)).to.equals("The number is greater or equal to 100!");
        });
    });


    describe("Tests NumberOperation", function () {

        describe("SumArrays", function () {

            it("Correct input", function () {
                expect(numberOperations.sumArrays([], [])).to.deep.equals([])
            });

            it("Correct input", function () {
                expect(numberOperations.sumArrays([1,2], [1,2])).to.deep.equals([2,4])
            })

            it("Correct input", function () {
                expect(numberOperations.sumArrays([1,2,3], [1,2])).to.deep.equals([2,4,3])
            })

            it("Correct input", function () {
                expect(numberOperations.sumArrays([1,2,"a"], [1,2])).to.deep.equals([2,4,"a"])
            })


        });
    });


});
