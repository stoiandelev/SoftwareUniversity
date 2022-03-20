import { render, page } from "./library.js";
import { homePage } from "./views/home.js";
import { loginPage } from "./views/login.js";
import { registerPage } from "./views/register.js";
import { topicPage } from "./views/topics.js";
import { getUserData } from "./api/util.js";
import { logout } from "./api/data.js"
import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";

let root = document.querySelector("main");
document.getElementById("logoutBtn").addEventListener("click", onLogout);

page(decorateContext);
page("/", homePage);
page("/topics", topicPage);
page("/topics/:id", detailsPage);
page("/login", loginPage);
page("/register", registerPage);
page("/create", createPage);

updateUserNav();
page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;
    next();
}

function updateUserNav() {
    let userData = getUserData();

    if (userData) {
        // @ts-ignore
        document.querySelector(".user").style.display = "inline-block";
        // @ts-ignore
        document.querySelector(".guest").style.display = "none";
    } else {
        // @ts-ignore
        document.querySelector(".user").style.display = "none";
        // @ts-ignore
        document.querySelector(".guest").style.display = "inline-block";
    }
};


async function onLogout() {
    await logout();
    updateUserNav();
    page.redirect("/");
};