async function getInfo() {

    let stopId = document.getElementById("stopId").value;
    let stopNameElement = document.getElementById("stopName");
    let timeTableElement = document.getElementById("buses");

    let url = `http://localhost:3030/jsonstore/bus/businfo/${stopId}`;

    try {
        timeTableElement.replaceChildren();
        stopNameElement.textContent = "Loading..."
        let response = await fetch(url);
        if (response.status !== 200) {
            throw new Error("StopID is not found")
        }
        let data = await response.json();
        stopNameElement.textContent = data.name;

        Object.entries(data.buses).forEach(b => {
            let liElement = document.createElement("li");
            liElement.textContent = `Bus ${b[0]} arrives in ${b[1]} minutes`;
            timeTableElement.appendChild(liElement);
        })
        return data;
    } catch (error) {
        stopNameElement.textContent = "Error"
    }
}





