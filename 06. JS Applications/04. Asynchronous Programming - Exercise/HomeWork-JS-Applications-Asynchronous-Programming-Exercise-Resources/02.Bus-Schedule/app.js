function solve() {

    let label = document.querySelector("#info span");
    let departBTN = document.getElementById("depart");
    let arriveBTN = document.getElementById("arrive");
    let stop = {
        next: "depot",
        name: undefined
    }

    async function depart() {
        //get information for next stop
        departBTN.disabled = true;
        let url = `http://localhost:3030/jsonstore/bus/schedule/${stop.next}`;
        let response = await fetch(url);
        let data = await response.json();
        stop = data;

        label.textContent = `Next stop ${data.name}`;


        arriveBTN.disabled = false;
    }

    function arrive() {
        //display name off current stop
        label.textContent = `Arriving at ${stop.name}`;

        departBTN.disabled = false;
        arriveBTN.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();