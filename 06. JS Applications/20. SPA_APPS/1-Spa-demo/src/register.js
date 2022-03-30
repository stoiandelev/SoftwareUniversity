import { updateUserNav } from "./app.js";
import { showSection } from "./dom.js";
import { showHomePage } from "./home.js";

let section = document.getElementById("registerSection");
section.remove();

let form = section.querySelector("form");
form.addEventListener("submit", onSubmit);


export function showRegisterPage() {
    showSection(section);

};

async function onSubmit(event) {
    event.preventDefault();

    let formData = new FormData(form);

    let email = formData.get("email").trim();
    let password = formData.get("password").trim();
    let repass = formData.get("repass").trim();

    if (password != repass) {
        alert("Password don't match!");
        return;
    }

    try {
        let url= "http://localhost:3030/users/register";
        let response = await fetch(url,{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ email, password })

        });

        if(response.ok != true) {
            let error = await response.json()
            throw new Error(error.message);
        }

        let data = await response.json();
        let userData = {
            username: data.username,    
            id: data._id,
            token: data.accessToken
        };

        sessionStorage.setItem("userData", JSON.stringify(userData));
        updateUserNav();
        showHomePage();

    } catch (err) {
        alert(err.message);
    }



}