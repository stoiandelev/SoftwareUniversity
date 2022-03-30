// initialization
// find section
// detach section from DOM

import { showDetails } from "./details.js";
import { e, showView } from "./dom.js";

// display login

let section = document.getElementById("home-page");
section.remove();

export function showHome() {
    showView(section);
    getMovies();

};


let catalog = section.querySelector(".card-deck.d-flex.justify-content-center");
let url = "http://localhost:3030/data/movies"
async function getMovies() {
    catalog.replaceChildren(e("p", {}, "Loading..."));

    let response = await fetch(url);
    let data = await response.json();

    catalog.replaceChildren(...data.map(createMovieCard));

};

catalog.addEventListener("click",onDetailsMovie);
function onDetailsMovie(event) {
    event.preventDefault();
    let target = event.target;

    if(target.tagName == "BUTTON"){
        target = target.parentElement;
    }

    if(target.tagName == "A"){
        let id= target.dataset.id;
        showDetails(id);
    }
   

};

function createMovieCard(movie) {
    let element = e("div", { className: "card mb-4" });
    element.innerHTML = `
    <img class="card-img-top" src="${movie.img}"
        alt="Card image cap" width="400">
    <div class="card-body">
        <h4 class="card-title">${movie.title}</h4>
    </div>
    <div class="card-footer">
        <a data-id="${movie._id}" href="#/details/6lOxMFSMkML09wux6sAF">
        <button type="button" class="btn btn-info">Details</button>
        </a>
    </div>`;

    return element;
};









