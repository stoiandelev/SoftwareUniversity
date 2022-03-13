import{towns as townNames} from "./towns.js";
import { html,render } from "./node_modules/lit-html/lit-html.js";

let listTemplate =(towns) => html`
<ul>
      ${towns.map(town => html`<li class=${town.match ? "active" : ""}>${town.name}</li>`)}
</ul>`;

let towns = townNames.map(t=>({name: t, match: false}));

let root = document.getElementById("towns");
let input = document.getElementById("searchText");
let output = document.getElementById("result");
document.querySelector("button").addEventListener("click",onSearch);

update();

function onSearch() {
   let match = input.value.trim().toLowerCase();
   let matches = 0;
   for(let town of towns) {
      if(match && town.name.toLocaleLowerCase().includes(match)){
         town.match = true; 
         matches++;
      }else{
         town.match = false;
      }
   }
   
   output.textContent = `${matches} matches found`;
   input.value = " ";
   update();
   
   
}



function update() {
   render(listTemplate(towns),root);
}