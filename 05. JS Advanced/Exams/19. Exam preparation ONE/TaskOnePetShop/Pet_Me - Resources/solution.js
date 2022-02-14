function solve() {

    //взимам рефереции;
    let field = document.querySelectorAll("#container input");
    let addButton = document.querySelector("#container button");
    let petList = document.querySelector("#adoption ul");
    let adoptedList = document.querySelector("#adopted ul");

    let input = {
        name: field[0],
        age: field[1],
        kind: field[2],
        owner: field[3]
    }

    addButton.addEventListener("click", addPet);

    function addPet(event) {
        event.preventDefault();

        let name = input.name.value.trim();
        let age = Number(input.age.value.trim());
        let kind = input.kind.value.trim();
        let owner = input.owner.value.trim();

        if (name === "" || input.age.value === "" || Number.isNaN(age)
            || kind === "" || owner === "") {
            return;
        }
        let contactBtn = e("button", {}, "Contact with owner");

        //ако няма атрибути подаваме празен обект
        let pet = e("li", {},
            e("p", {},
                e("strong", {}, name),
                " is a ",
                e("strong", {}, age),
                " year old ",
                e("strong", {}, kind),
            ),
            e("span", {}, `Owner: ${owner}`),
            contactBtn
        );

        contactBtn.addEventListener("click", contact);

        function contact() {
            let confirmInput = e("input", {placeholder: "Enter your names"});
            let confirmButton = e("button", {}, `Yes! I take it!`);
            let confirmDiv = e("div", {},
                confirmInput,
                confirmButton
            )
            confirmButton.addEventListener("click", adopt.bind(null, confirmInput, pet));

            contactBtn.remove();
            pet.appendChild(confirmDiv);
        }

        petList.appendChild(pet);

        input.name.value = "";
        input.age.value = "";
        input.kind.value = "";
        input.owner.value = "";


    }

    function adopt(input, pet) {
        let newOwner = input.value;
        if (newOwner === "") {
            return;
        }
        let checkButton = e("button", {}, "Checked");
        checkButton.addEventListener("click", check.bind(null, pet));


        pet.querySelector("div").remove();
        pet.appendChild(checkButton);

        pet.querySelector("span").textContent = `New Owner: ${newOwner}`;
        adoptedList.appendChild(pet);
    }

    function check(pet) {
        pet.remove();
    }


    //func която ще създава елементи
    function e(type, attribute, ...content) {
        let element = document.createElement(type);
        //oчакваме да е обект
        // ще копира всички свойства върху обекта с атрибути
        for (let prop in attribute) {
            element[prop] = attribute[prop];
        }
        //всеки един елемент добавяме като дете
        // for of защото content is Array
        for (let item of content) {
            if (typeof item === "string" || typeof item === "number") {
                item = document.createTextNode(item);
            }
            element.appendChild(item);
        }
        return element;
    }


}

