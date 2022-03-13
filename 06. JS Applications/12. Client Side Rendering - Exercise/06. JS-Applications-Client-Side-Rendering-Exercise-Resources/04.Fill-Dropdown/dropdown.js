import { html, render } from "./node_modules/lit-html/lit-html.js";

let selectTemplate = (items) => html`
<select id="menu">
    ${items.map(i => html`<option value=${i._id}>${i.text}</option>`)}
</select>
 `;


let root = document.querySelector("div");
document.querySelector("form").addEventListener("submit", addItem);
let url = "http://localhost:3030/jsonstore/advanced/dropdown";
getData();

async function getData() {
    let response = await fetch(url);
    let data = await response.json();
    update(Object.values(data));
}


function update(items) {
    let result = selectTemplate(items);
    render(result, root);
}

async function addItem(event) {
    event.preventDefault();
    let text = document.getElementById("itemText").value;

    let item = {
        text
    }

    let response = await fetch(url, {
        method:"POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(item)
    });
    
    if (response.ok) {
        getData();
    }
    

}

