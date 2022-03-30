import { showCatalogPage } from "./catalog.js";
import { showAboutPage, showHomePage } from "./home.js";
import { showLoginPage } from "./login.js";
import { showRegisterPage } from "./register.js";


document.getElementById("logoutBtn").addEventListener("click", onLogout);
document.querySelector("nav").addEventListener("click", onNavigate);


let section = {
    "homeBtn": showHomePage,
    "catalogBtn": showCatalogPage,
    "aboutBtn": showAboutPage,
    "loginBtn": showLoginPage,
    "registerBtn": showRegisterPage
};

updateUserNav();
//start app in homePage
showHomePage();




function onNavigate(event) {

    if (event.target.tagName == "A") {
        let view = section[event.target.id];
        if (typeof view == "function") {
            event.preventDefault();
            view();
        }
    }
}

export function updateUserNav() {
    let userData = JSON.parse(sessionStorage.getItem("userData"));
    if (userData != null) {
        document.getElementById("userNav").style.display = "inline-block";
        document.getElementById("guestNav").style.display = "none";
    } else {
        document.getElementById("userNav").style.display = "none";
        document.getElementById("guestNav").style.display = "inline-block";
    }
};

async function onLogout(event) {
    event.stopImmediatePropagation();

    let { token } = JSON.parse(sessionStorage.getItem("userData"));

    let response = await fetch("http://localhost:3030/users/logout",{
        headers: { 
            "X-Authorization": token
        }
    });

    sessionStorage.removeItem("userData");
    updateUserNav();
    showHomePage();
}