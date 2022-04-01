import { showCatalogPage } from "./views/catalog.js";
import { showCreatePage } from "./views/create.js";
import { showDetailsPage } from "./views/details.js";
import { showHomePage } from "./views/home.js";
import { showLoginPage } from "./views/login.js";
import { showRegisterPage } from "./views/register.js";
import { showSection } from "./src/dom.js";
import { logout } from "./api/data.js";

let links = {
    "homeLink": "home",
    "getStartedLink": "home",
    "catalogLink": "catalog",
    "loginLink": "login",
    "registerLink": "register",
    "createLink": "create",
};

let views = {
    "home": showHomePage,
    "catalog": showCatalogPage,
    "login": showLoginPage,
    "register": showRegisterPage,
    "create": showCreatePage,
    "details": showDetailsPage
};

let nav = document.querySelector("nav");
nav.addEventListener("click", onNavigate);

document.getElementById("logoutBtn").addEventListener("click", async (event) => {
    event.preventDefault();
    await logout();
    updateNav();
    goTo("home");
});


let ctx = {
    goTo,
    showSection,
    updateNav
};

updateNav();
//start app in homePage
goTo("home");

function onNavigate(event) {
    let name = links[event.target.id];
    if (name) {
        event.preventDefault();
        goTo(name);
    };
};

function goTo(name, ...params) {
    let view = views[name];
    if (typeof view == "function") {
        view(ctx, ...params);
    }
};

export function updateNav() {
    let userData = JSON.parse(sessionStorage.getItem("userData"));
    if (userData != null) {
        [...nav.querySelectorAll(".user")].forEach(link => link.style.display = "block");
        [...nav.querySelectorAll(".guest")].forEach(link => link.style.display = "none");
    } else {
        [...nav.querySelectorAll(".user")].forEach(link => link.style.display = "none");
        [...nav.querySelectorAll(".guest")].forEach(link => link.style.display = "block");
    }
}

