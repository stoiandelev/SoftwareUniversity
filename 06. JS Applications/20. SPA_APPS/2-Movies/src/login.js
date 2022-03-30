// initialization
// find section
// detach section from DOM

import { updateNav } from "./app.js";
import { showView } from "./dom.js";
import { showHome } from "./home.js";

// display login

let section = document.getElementById("form-login");
section.remove();

export function showLogin() {
    showView(section);
};


let form = section.querySelector("form");
form.addEventListener("submit", onLogin);

let url = "http://localhost:3030/users/login"

async function onLogin(event) {
    event.preventDefault();

    let formData = new FormData(form);
    let email = formData.get("email").trim();
    let password = formData.get("password").trim();


    try {   
        let response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ email, password })

        });

        if (response.ok != true) {
            let error = await response.json();
            throw new Error(error.message);
        }
        
        let data = await response.json();
        sessionStorage.setItem("userData", JSON.stringify({
            email: data.email,
            id: data._id,
            token: data.accessToken
        }));

        form.reset();
        updateNav();
        showHome();

    } catch (err) {
        alert(err.message);
    }

}