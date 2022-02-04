// с деструктириране си взимаме, за да ползваме expect and assert
const {expect, assert} = require("chai");
const {isOddOrEven} = require("./isOddOrEven");


describe("Test oddOrEven", () => {

    it("Test Invalid Input", () => {
        expect(isOddOrEven(1)).to.be.undefined;
        expect(isOddOrEven({})).to.be.undefined;
        expect(isOddOrEven([])).to.be.undefined;
    });

    it("Test is odd is returned", () => {
        expect(isOddOrEven("abc")).to.be.equal("odd");
    })

    it("Test is even is returned", () => {
        expect(isOddOrEven("abed")).to.be.equal("even");
        expect(isOddOrEven("")).to.be.equal("even");
    })
})