import { logout } from "./api/data.js";
import { page, render } from "./api/library.js";
import { getUserData } from "./api/util.js";
import { catalogPage } from "./views/catalog.js";
import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";
import { homePage } from "./views/home.js";
import { loginPage } from "./views/login.js";
import { profilePage } from "./views/profile.js";
import { registerPage } from "./views/register.js";


let root = document.querySelector("main");
document.getElementById("logoutBtn").addEventListener("click", onLogout);

page(decorateContext);
page("/", homePage);
page("/memes", catalogPage);
page("/login", loginPage);
page("/register", registerPage);
page("/create", createPage);
page("/details/:id", detailsPage);
page("/edit/:id", editPage);
page("/profile", profilePage);


updateUserNav();
page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;

    next();
};

function updateUserNav() {
    let userData = getUserData();

    if (userData) {
        // @ts-ignore
        document.querySelector(".user").style.display = "block";
        // @ts-ignore
        document.querySelector(".guest").style.display = "none";
        document.querySelector(".user span").textContent = `Welcome, ${userData.email}`
    } else {
        // @ts-ignore
        document.querySelector(".user").style.display = "none";
        // @ts-ignore
        document.querySelector(".guest").style.display = "block";
    }
};

function onLogout() {
    logout();
    updateUserNav();
    page.redirect("/");   
};



