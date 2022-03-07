import { showHome } from "./home.js";
import { showLogin } from "./login.js";
import { showRegister } from "./register.js";
import { showDetails } from "./details.js";
import { showCreate } from "./create.js";


// 1. create placeholder modules for every view.
// 2. configure and test navigation, delegation on navigation
// 3. implements modules
// 4. create async functions for requests
// 5. implements DOM logic


// 6. order of views
// 6.1 catalog - homeView
// 6.2 login-register
// 6.3 create
// 6.4 details
// 6.5 likes
// 6.6 edit
// 6.7 delete
// 6.8 logout


// // for test in browser
// window.showHome=showHome;
// window.showDetails=showDetails;
// window.showCreate=showCreate;

// association between link and function

showHome();



let nav = document.querySelector("nav");
document.getElementById("logoutBtn").addEventListener("click", onLogout);

async function onLogout(event) {
    event.preventDefault();
    event.stopImmediatePropagation();

    let { token } = JSON.parse(sessionStorage.getItem("userData"));
    await fetch("http://localhost:3030/users/logout", {
        headers: {
            "X-Authorization":token
        }
    });
    sessionStorage.removeItem("userData");
    updateNav();
    showLogin();
}

let views = {
    "homeLink": showHome,
    "loginLink": showLogin,
    "registerLink": showRegister
};

nav.addEventListener("click", onNavFunction);
function onNavFunction(event) {
    let view = views[event.target.id];
    if (typeof view == ("function")) {
        event.preventDefault();
        view();
    }
};



document.getElementById("createLink").addEventListener("click", onCreateLinkMovie)
function onCreateLinkMovie(event) {
    showCreate();
};

export function updateNav() {
    let userData = JSON.parse(sessionStorage.getItem("userData"));
    if (userData != null) {

        nav.querySelector("#welcomeMsg").textContent = `Welcome, ${userData.email}`;
        [...nav.querySelectorAll(".user")].forEach(e => e.style.display = "block");
        [...nav.querySelectorAll(".guest")].forEach(e => e.style.display = "none");
    } else {
        [...nav.querySelectorAll(".user")].forEach(e => e.style.display = "none");
        [...nav.querySelectorAll(".guest")].forEach(e => e.style.display = "block");
    }
};

updateNav();








