// initialization
// find section
// detach section from DOM

import { updateNav } from "./app.js";
import { showView } from "./dom.js";
import { showHome } from "./home.js";

// display login

let section = document.getElementById("form-sign-up");
section.remove();

let form = section.querySelector("form");
form.addEventListener("submit", onSubmitRegister);


export function showRegister() {
    showView(section);
    
};


async function onSubmitRegister(event) {
    event.preventDefault();

    let formData = new FormData(form);

    let email = formData.get("email").trim();
    let password = formData.get("password").trim();
    let repass = formData.get("repeatPassword").trim();

    if (password != repass) {
        alert("Password don't match!");
        return;
    }

    try {
        let url = "http://localhost:3030/users/register";
        let response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ email, password })

        });

        if (response.ok != true) {
            let error = await response.json()
            throw new Error(error.message);
        }

        let data = await response.json();
        let userData = {
            email: data.email,
            id: data._id,
            token: data.accessToken
        };

        sessionStorage.setItem("userData", JSON.stringify(userData));
        updateNav();
        showHome();

    } catch (err) {
        alert(err.message);
    }
}
