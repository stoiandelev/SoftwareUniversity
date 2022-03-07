import * as api from '../api/data.js';

let section = document.getElementById("loginSection");
section.remove();

let form = section.querySelector("form");
form.addEventListener("submit", onSubmit);

let ctx = null;

export function showLoginPage(ctxTarget) {
    ctx = ctxTarget;
    ctx.showSection(section);

};

async function onSubmit(event) {
    event.preventDefault();

    let formData = new FormData(form);
    let email = formData.get("email").trim();
    let password = formData.get("password").trim();

    await login(email, password);
    ctx.updateUserNav();
    ctx.goTo("home");

}