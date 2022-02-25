class Parking {
    constructor(capacity) {
        this.capacity = Number(capacity);
        this.vehicles = [];
    }

    addCar(carModel, carNumber) {
        if (this.vehicles.length === this.capacity) {
            throw new Error("Not enough parking space.");
        }
        let car = {
            carModel: carModel,
            carNumber: carNumber,
            payed: false
        }
        this.vehicles.push(car);
        return `The ${carModel}, with a registration number ${carNumber}, parked.`
    }

    removeCar(carNumber) {
        let vehicle = this.vehicles.find(v => v.carNumber === carNumber);
        if (vehicle === undefined) {
            throw new Error("The car, you're looking for, is not found.")
        }
        if (vehicle.payed === false) {
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`)
        }
        // става ли въпрос за премахване в масив с индекс и spice
        let indexToRemove = this.vehicles.indexOf(vehicle);
        this.vehicles.splice(indexToRemove, 1);
        return `${carNumber} left the parking lot.`
    }

    pay(carNumber) {
        let car = this.vehicles.find(v => v.carNumber === carNumber);
        if (car === undefined) {
            throw new Error(`${carNumber} is not in the parking lot.`)
        }
        if (car.payed === true) {
            throw new Error(`${carNumber}'s driver has already payed his ticket.`)
        }
        car.payed = true;
        return `${carNumber}'s driver successfully payed for his stay.`
    }

    getStatistics(carNumber) {
        if (carNumber === undefined) {
            let emptySlots = this.capacity - this.vehicles.length;
            let massage = `The Parking Lot has ${emptySlots} empty spots left.`
            let sorted = this.vehicles
                .sort((a, b) => a.carModel.localeCompare(b.carModel));
            let massage2 = "";
            for (let vehicle of sorted) {
                massage2 += `\n${vehicle.carModel} == ${vehicle.carNumber} - ${vehicle.payed === true ? "Has payed" : "Not payed"}`
            }
            return massage + massage2;
        } else {
            let car = this.vehicles.find(v => v.carNumber === carNumber);
            return `${car.carModel} == ${car.carNumber} - ${car.payed === true ? "Has payed" : "Not payed"}`
        }
    }
}

const parking = new Parking(12);
console.log(parking.addCar("Volvo t600", "TX3691CA"));
console.log(parking.getStatistics());
console.log(parking.pay("TX3691CA"));
console.log(parking.removeCar("TX3691CA"));
