import { render, page } from "./lib.js";
import { getUserData, loadMovie } from "./util.js";
import { catalogPage } from "./views/catalog.js";
import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";
import { loginPage } from "./views/login.js";
import { registerPage } from "./views/register.js";


let root = document.querySelector("main");

page(decorateContext);
page("/home", catalogPage);
page("/create", createPage);
page("/edit/:id",loadMovie, editPage);
page("/details/:id",loadMovie, detailsPage);
page("/login", loginPage);
page("/register", registerPage);
page("/", "/home");

updateUserNav();
page.start();

async function decorateContext(ctx, next) {
    ctx.render = (template) => render(template, root);
    ctx.updateUserNav = updateUserNav;
    next();
};
 
function updateUserNav() {
    let userData = getUserData();
    if (userData) {
        // @ts-ignore
        [...document.querySelectorAll("nav .user")].forEach(el => el.style.display = "block");
        // @ts-ignore
        [...document.querySelectorAll("nav .guest")].forEach(el => el.style.display = "none");
        document.getElementById("welcomeMsg").textContent = `Welcome ${userData.email}`;
    } else {
        // @ts-ignore
        [...document.querySelectorAll("nav .user")].forEach(el => el.style.display = "none");
        // @ts-ignore
        [...document.querySelectorAll("nav .guest")].forEach(el => el.style.display = "block");
    }

};

