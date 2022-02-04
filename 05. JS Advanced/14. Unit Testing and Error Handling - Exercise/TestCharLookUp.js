const {expect, assert} = require("chai");
const {lookupChar} = require("./CharLookup");

describe("Test case for CharLookUp(str,index)", () => {

    it("Test Invalid Input", () => {
       expect(lookupChar(2,2)).to.be.undefined;
    })

    it("Test Invalid Input", () => {
        expect(lookupChar("2","2")).to.be.undefined;
    })

    it("Test Invalid Input", () => {
        expect(lookupChar("2",2.34)).to.be.undefined;
    })

    it("Test Incorrect index", () => {
        expect(lookupChar("text",22)).to.be.equal("Incorrect index");
    })

    it("Test Incorrect index", () => {
        expect(lookupChar("text",-3)).to.be.equal("Incorrect index");
    })

    it("Test Incorrect index", () => {
        expect(lookupChar("text",4)).to.be.equal("Incorrect index");
    })

    it("Test Correct index", () => {
        expect(lookupChar("text",3)).to.be.equal("t");
    })

    it('should return "l" on lookupChar("hello", 3)', () => {
        expect(lookupChar("hello", 3)).to.equal('l');
    });


})