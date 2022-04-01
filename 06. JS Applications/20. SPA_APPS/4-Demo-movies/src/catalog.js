import { e } from "./dom.js";
import { getAllMovies } from "../api/data.js";

let section = document.getElementById("catalogSection");
section.remove();
let ul = section.querySelector("ul")

export function showCatalogPage(ctx) {
    ctx.showSection(section);
    loadMovies();
};

async function loadMovies() {
    ul.replaceChildren(e("p", {}, "Loading..."))

    let movies = await getAllMovies();

    ul.replaceChildren(...movies.map(createMovieCard));
}

function createMovieCard(movie) {
    return e("li", {}, movie.title);
}





