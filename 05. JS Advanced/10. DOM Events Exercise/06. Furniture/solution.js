function solve() {
    let allBtns = document.querySelectorAll("#exercise button");
    let generateBtn = allBtns[0].addEventListener("click", onClick);
    let buyBtn = allBtns[1].addEventListener("click", onClickResult);

    let textAreas = document.querySelectorAll("#exercise textarea");
    let inputArea = textAreas[0];
    let resultArea = textAreas[1];

    let table = document.querySelector("tbody");

    function onClick(e) {
        let input = Array.from(JSON.parse(inputArea.value)).forEach((el) => {
            let tr = document.createElement("tr");

            let imgTd = document.createElement("td");
            let img = document.createElement("img");
            img.src = el.img;
            imgTd.appendChild(img);

            let nameTd = document.createElement("td");
            let nameP = document.createElement("p");
            nameP.textContent = el.name;
            nameTd.appendChild(nameP);

            let priceTd = document.createElement("td");
            let priceP = document.createElement("p");
            priceP.textContent = Number(el.price);
            priceTd.appendChild(priceP);

            let decFactorTd = document.createElement("td");
            let decP = document.createElement("p");
            decP.textContent = Number(el.decFactor);
            decFactorTd.appendChild(decP);

            let inputTd = document.createElement("td");
            let input = document.createElement("input");
            input.type = "checkbox";
            inputTd.appendChild(input);

            tr.appendChild(imgTd);
            tr.appendChild(nameTd);
            tr.appendChild(priceTd);
            tr.appendChild(decFactorTd);
            tr.appendChild(inputTd);

            table.appendChild(tr);
        });
    }

    function onClickResult(e) {
        let names = [];
        let totalPrice = 0;
        let avrgDec = 0;
        let decCounter = 0;

        let boxes = Array.from(
            document.querySelectorAll('input[type="checkbox"]:checked')
        ).map((x) => x.parentElement.parentElement);

        for (const box of boxes) {
            names.push(box.children[1].children[0].textContent);
            (totalPrice += Number(box.children[2].children[0].textContent)),
                (avrgDec += Number(box.children[3].children[0].textContent)),
                (decCounter += 1);
        }
        avrgDec = avrgDec / decCounter;

        let result = `Bought furniture: ${names.join(", ")}
Total price: ${totalPrice.toFixed(2)}
Average decoration factor: ${avrgDec}`;
        resultArea.value = result;
    }
}