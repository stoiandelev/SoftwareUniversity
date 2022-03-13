import { html, render } from "./node_modules/lit-html/lit-html.js";

let url = "http://localhost:3030/jsonstore/advanced/table/";

let studentRow = (student) => html`
<tr class=${student.match ? "select" : "" }>
   <td>${student.item.firstName} ${student.item.lastName}</td>
   <td>${student.item.email}</td>
   <td>${student.item.course}</td>
</tr>`;

let input = document.getElementById("searchField");
document.getElementById("searchBtn").addEventListener("click", onSearch);
let students;
start();

function update() {
   render(students.map(studentRow), document.querySelector("tbody"));
}

async function start() {
   let response = await fetch(url);
   let date = await response.json()
   students = Object.values(date).map(s=>({ item: s, match: false}));
   update();
}

function onSearch() {
   let value = input.value.trim().toLocaleLowerCase();
   for (let  student  of students) {
      student.match = Object.values(student.item).some(v => value && v.toLocaleLowerCase().includes(value));
   }
   update();
}