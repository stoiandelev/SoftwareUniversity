window.addEventListener('load', solve);

function solve() {

    let modelField = document.querySelector("#model");
    let yearField = document.querySelector("#year");
    let descriptionField = document.querySelector("#description");
    let priceField = document.querySelector("#price");
    let addBtn = document.querySelector("#add");
    let totalPrice = 0;

    addBtn.addEventListener("click", addHeader);

    function addHeader(event) {
        event.preventDefault();

        let model = modelField.value;
        let year = yearField.value;
        let description = descriptionField.value;
        let price = priceField.value;

        if (model === "" || description === "" ||
            Number.isNaN(Number(year)) || year < 1 ||
            Number.isNaN(Number(price)) || price < 1) {
            return
        }

        modelField.value = "";
        yearField.value = "";
        descriptionField.value = "";
        priceField.value = "";

        price = Number(price);

        let tBody = document.querySelector("#furniture-list");

        //бутоните
        let moreLessBtn = ev("button", {className: "moreBtn"}, "More Info");
        let byuBtn = ev("button", {className: "buyBtn"}, "Buy it");

        //tr info
        let trInfo = ev("tr", {className: "info"},
            ev("td", {}, `${model}`),
            ev("td", {}, `${price.toFixed(2)}`),
            ev("td", {}, moreLessBtn, byuBtn));

        //tr hide
        let trHide = ev("tr", {className: "hide"},
            ev("td", {}, `Year: ${year}`),
            ev("td", {colSpan: "3"}, `Description: ${description}`));

        tBody.appendChild(trInfo);
        tBody.appendChild(trHide);

        moreLessBtn.addEventListener("click", () => {
            if (moreLessBtn.textContent === "More Info") {
                moreLessBtn.textContent = "Less Info";
                trHide.style = 'display: contents';
            } else {
                moreLessBtn.textContent = "More Info";
                trHide.style = 'display: none';
            }
        });

        byuBtn.addEventListener("click", () => {
            trInfo.remove();
            trHide.remove();
            totalPrice += price;
            document.querySelector(".total-price").textContent = totalPrice.toFixed(2);
        })
    }


    function ev(type, attributes, ...content) {
        const result = document.createElement(type);
        for (let [attr, value] of Object.entries(attributes || {})) {
            if (attr.substring(0, 2) === 'on') {
                result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
            } else {
                result[attr] = value;
            }
        }
        content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);
        content.forEach(e => {
            if (typeof e == 'string' || typeof e == 'number') {
                const node = document.createTextNode(e);
                result.appendChild(node);
            } else {
                result.appendChild(e);
            }
        });
        return result;
    }
}
