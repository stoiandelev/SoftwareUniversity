import { updateUserNav } from "./app.js";
import { showSection, e } from "./dom.js";
import { showLoginPage } from "./login.js";

let section = document.getElementById("catalogSection");
section.remove();
let ul = section.querySelector("ul")

export function showCatalogPage() {
    showSection(section);
    loadMovies();
};

async function loadMovies() {
    ul.replaceChildren(e("p", {}, "Loading..."))


    let options = { method: "GET", headers: {} };
    let userData = JSON.parse(sessionStorage.getItem("userData"));
    if (userData != null) {
        options.headers["X-Authorization"] = userData.token;
    };

    let response = await fetch("http://localhost:3030/data/movies", options);

    if (response.status == 403) {
        sessionStorage.removeItem("userData");
        updateUserNav();
        showLoginPage();
    }

    let movies = await response.json();

    ul.replaceChildren(...movies.map(createMovieCard));
}

function createMovieCard(movie) {
    return e("li", {}, movie.title);
}





