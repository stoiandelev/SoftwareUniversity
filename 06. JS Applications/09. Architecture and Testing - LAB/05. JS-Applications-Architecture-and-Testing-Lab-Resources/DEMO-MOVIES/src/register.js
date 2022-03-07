import { register } from "../api/data.js";


let section = document.getElementById("registerSection");
section.remove();

let form = section.querySelector("form");
form.addEventListener("submit", onSubmit);

let ctx = null;

export function showRegisterPage(ctxTargets) {
    ctx = ctxTargets;
    ctx.showSection(section);

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



    await register(email, password);
        ctx.updateUserNav();
        ctx.goTo("home");
}