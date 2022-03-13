import { html, render } from "./node_modules/lit-html/lit-html.js";


let root = document.getElementById("root");
document.querySelector("form").addEventListener("submit", (event) => {
    event.preventDefault();
    let towns = document.getElementById("towns").value.split(",").map(e => e.trim());
    let result = listTemplate(towns);
    render(result, root);
});

let listTemplate = (towns) => html`
<ul>
    ${towns.map(town => html`<li>${town}</li>`)}
</ul>`;

