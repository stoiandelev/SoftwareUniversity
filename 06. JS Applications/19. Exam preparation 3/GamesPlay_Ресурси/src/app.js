import { html, render, page } from "../src/api/library.js";
import { logout } from "./api/data.js";
import { getUserData } from "./api/util.js";
import { catalogPage } from "./views/catalog.js";
import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";
import { homePage } from "./views/home.js";
import { loginPage } from "./views/login.js";
import { registerPage } from "./views/register.js";

let root = document.querySelector("main");

document.getElementById("logoutBtn").addEventListener("click", onLogout);

page(decorateContext);
page("/", homePage);
page("/login", loginPage);
page("/register", registerPage);
page("/catalog", catalogPage);
page("/create", createPage);
page("/details/:id", detailsPage);
page("/edit/:id", editPage);
// page("/my-books", myBooksPage);
// page("/search", searchPage);




updateUserNav()
page.start();


function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;

    next();
};

async function onLogout() {
    await logout();
    updateUserNav();
    page.redirect("/");
};



function updateUserNav() {
    let userData = getUserData();

    if (userData) {
        document.getElementById("user").style.display = "block";
        document.getElementById("guest").style.display = "none";
    } else {
        document.getElementById("user").style.display = "none";
        document.getElementById("guest").style.display = "block";
    }
};
