window.addEventListener('load', solve);

function solve() {
    let modelFields = document.getElementById("model");
    let yearFields = document.getElementById("year");
    let descriptionFields = document.getElementById("description");
    let priceFields = document.getElementById("price");
    let addButton = document.getElementById("add");
    let furnitureList = document.getElementById("furniture-list");
    let totalPrice = document.querySelector(".total-price");

    addButton.addEventListener("click", addFurniture);

    function addFurniture(event) {
        event.preventDefault();
        let yearValue = Number(yearFields.value);
        let priceValue = Number(priceFields.value);

        if (modelFields.value !== "" && descriptionFields.value !== "" &&
            yearValue > 0 && priceValue > 0) {

            let tr = document.createElement("tr");
            tr.classList.add("info");
            tr.innerHTML = `<td>${modelFields.value}</td>
            <td>${priceValue.toFixed(2)}</td>
            <td>
            <button class="moreBtn">More Info</button>
             <button class="buyBtn">Buy it</button>
            </td>`;

            let hideTr = document.createElement("tr");
            hideTr.classList.add("hide");
            hideTr.innerHTML = `<td>Year: ${yearValue}</td>
                            <td colspan="3">Description: ${descriptionFields.value}</td>`;

            furnitureList.appendChild(tr);
            furnitureList.appendChild(hideTr);

            let moreInfoButtonS = tr.querySelectorAll("button");
            moreInfoButtonS[0].addEventListener("click", showMoreInfo);
            moreInfoButtonS[1].addEventListener("click", byFurniture);

        }


        modelFields.value = "";
        yearFields.value = "";
        descriptionFields.value = "";
        priceFields.value = "";
    }

    function showMoreInfo(e) {
        let moreInfoTr = e.target.parentElement.parentElement.nextElementSibling
        if (e.target.textContent === "More Info") {
            e.target.textContent = "Less Info";
            moreInfoTr.style.display = "contents";
        } else {
            e.target.textContent = "More Info";
            moreInfoTr.style.display = "none";
        }
    }

    function byFurniture(e) {
        let tr = e.target.parentElement.parentElement;
        let hideTr = tr.nextElementSibling;
        hideTr.parentElement.removeChild(hideTr);
        let price = Number(tr.querySelectorAll("td")[1].textContent);
        totalPrice.textContent = (Number(totalPrice.textContent) + price).toFixed(2);

        tr.parentElement.removeChild(tr);
    }

}
