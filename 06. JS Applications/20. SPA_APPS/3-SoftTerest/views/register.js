import { register } from '../api/data.js';


let section = document.getElementById("registerPage");
section.remove();

let form = section.querySelector("form");
form.addEventListener("submit", onSubmit);
let ctx = null;

export async function showRegisterPage(ctxTarget) {
    ctx = ctxTarget;
    ctx.showSection(section);
};

async function onSubmit(event) {
    event.preventDefault();
    let formData = new FormData(form);
    let email = formData.get("email").trim();
    let password = formData.get("password").trim();
    let repass = formData.get("repeatPassword").trim();

    if (!email || !password) {
        return alert('All fields are required!');;
    }

    if (password != repass) {
        return alert('Password don\'t match!');
    }

    await register(email, password);
    form.reset();
    ctx.goTo("home");
    ctx.updateNav();

};





