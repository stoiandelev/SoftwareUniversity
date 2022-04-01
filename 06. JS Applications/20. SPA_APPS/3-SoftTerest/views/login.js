import { login } from '../api/data.js';

let section = document.getElementById("loginPage");
section.remove();

let form = section.querySelector("form");
form.addEventListener("submit", onSubmit);
let ctx = null;

export async function showLoginPage(ctxTarget) {
    ctx = ctxTarget;
    ctx.showSection(section);
};

async function onSubmit(event) {
    event.preventDefault();
    let formData = new FormData(form);
    let email = formData.get("email").trim();
    let password = formData.get("password").trim();

    await login(email, password);
    form.reset();
    ctx.goTo("home");
    ctx.updateNav();

};





