class SummerCamp {
    constructor(organizer, location) {
        this.organizer = organizer;
        this.location = location;
        this.priceForTheCamp = {
            child: 150,
            student: 300,
            collegian: 500
        }
        this.listOfParticipants = [];
    }

    registerParticipant(name, condition, money) {
        if (condition !== "child" && condition !== "student" && condition !== "collegian") {
            throw new Error("Unsuccessful registration at the camp.");
        }

        if (this.listOfParticipants.some(x => x.name === name)) {
            throw new Error(`The ${name} is already registered at the camp.`)
        }

        let price = this.priceForTheCamp[condition];

        if (money < price) {
            return `The money is not enough to pay the stay at the camp.`;
        }

        let newParticipant = {
            name: name,
            condition: condition,
            power: 100,
            wins: 0
        }

        this.listOfParticipants.push(newParticipant);
        return `The ${name} was successfully registered.`
    }

    unregisterParticipant(name) {
        let participant = this.listOfParticipants.find(x => x.name === name);

        if (!participant) {
            throw new Error(`The ${name} is not registered in the camp.`);
        }

        let index = this.listOfParticipants.indexOf(participant);
        this.listOfParticipants.splice(index, 1);


        return `The ${name} removed successfully.`
    }

    timeToPlay(typeOfGame, participant1, participant2) {
        if (typeOfGame === "WaterBalloonFights") {
            let player1 = this.listOfParticipants.find(x => x.name === participant1);
            let player2 = this.listOfParticipants.find(x => x.name === participant2);

            if (!player1 || !player2) {
                throw new Error("Invalid entered name/s.")
            }

            if (player1.condition !== player2.condition) {
                throw new Error(`Choose players with equal condition.`);
            }

            if (player1.power > player2.power) {
                player1.wins += 1;
                return `The ${participant1} is winner in the game ${typeOfGame}.`;
            } else if (player2.power > player1.power) {
                player2.wins += 1;
                return `The ${participant2} is winner in the game ${typeOfGame}.`;
            } else {
                return `There is no winner.`;
            }
        } else if (typeOfGame === "Battleship") {
            let player1 = this.listOfParticipants.find(x => x.name === participant1);

            if (!player1) {
                throw new Error("Invalid entered name/s.")
            }

            player1.power += 20;
            return `The ${participant1} successfully completed the game ${typeOfGame}.`;
        }


    }


    toString() {
        let output = [];
        let numberOfParticipants = this.listOfParticipants.length;
        output.push(`${this.organizer} will take ${numberOfParticipants} participants on camping to ${this.location}`);

        let sortedDesc = this.listOfParticipants.sort((a, b) => b.wins - a.wins);

        for (let player of sortedDesc) {
            output.push(`${player.name} - ${player.condition} - ${player.power} - ${player.wins}`);
        }
        return output.join("\n");


    }


}

const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));
console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));

console.log(summerCamp.toString());





    
