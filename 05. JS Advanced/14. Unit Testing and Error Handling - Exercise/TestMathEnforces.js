const {expect, assert} = require("chai");
const {mathEnforcer} = require("./MathEnforcer");

describe("Test mathEnforcer addFive functionality", ()=> {
    describe('addFive', () => {

        it('check function addFive for incorrect input type', () => {
            expect(mathEnforcer.addFive("4")).to.be.undefined;
            expect(mathEnforcer.addFive("sdfsdfsd")).to.be.undefined;
            expect(mathEnforcer.addFive([1])).to.be.undefined;
        });
        it('check function addFive for correct input type', () => {
            expect(mathEnforcer.addFive(1)).to.be.equal(6);
            expect(mathEnforcer.addFive(5)).to.be.equal(10);
            expect(mathEnforcer.addFive(-5)).to.be.equal(0);
            expect(mathEnforcer.addFive(5.5)).to.be.equal(10.5);
        });

    });

    describe('subTen', () => {

        it('check function subtractTen for incorrect input type', () => {
            expect(mathEnforcer.subtractTen("4")).to.be.undefined;
            expect(mathEnforcer.subtractTen("sdfsdfsd")).to.be.undefined;
            expect(mathEnforcer.subtractTen([1])).to.be.undefined;
        });
        it('check function subTen for correct input type', () => {
            expect(mathEnforcer.subtractTen(1)).to.be.equal(-9);
            expect(mathEnforcer.subtractTen(10)).to.be.equal(0);
            expect(mathEnforcer.subtractTen(15)).to.be.equal(5);
            expect(mathEnforcer.subtractTen(10.5)).to.be.equal(0.5);
            expect(mathEnforcer.subtractTen(-10)).to.be.equal(-20);
        });

    });

    describe('sum', () => {

        it('check function sum for incorrect input type', () => {
            expect(mathEnforcer.sum("4", 1)).to.be.undefined;
            expect(mathEnforcer.sum("h", "d")).to.be.undefined;
            expect(mathEnforcer.sum([1, 2])).to.be.undefined;
            expect(mathEnforcer.sum(1, "5")).to.be.undefined;
        });
        it('check function sum for correct input type', () => {
            expect(mathEnforcer.sum(1, 1)).to.be.equal(2);
            expect(mathEnforcer.sum(10, 10)).to.be.equal(20);
            expect(mathEnforcer.sum(-5, -5)).to.be.equal(-10);
            expect(mathEnforcer.sum(-5, 5)).to.be.equal(0);
            expect(mathEnforcer.sum(1.5, 1.5)).to.be.equal(3.0);
            expect(mathEnforcer.sum(-10.5, -10.5)).to.be.equal(-21.0);
        });

    });
})
