import { login } from "../api/data.js";
import { html, render } from "../api/library.js";

let loginTemplate = (onLogin) => html`
<section id="login-page" class="auth">
    <form @submit=${onLogin} id="login">

        <div class="container">
            <div class="brand-logo"></div>
            <h1>Login</h1>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="Sokka@gmail.com">

            <label for="login-pass">Password:</label>
            <input type="password" id="login-password" name="password">
            <input type="submit" class="btn submit" value="Login">
            <p class="field">
                <span>If you don't have profile click <a href="/register">here</a></span>
            </p>
        </div>
    </form>
</section>`;



export function loginPage(ctx) {
    ctx.render(loginTemplate(onLogin));

    async function onLogin(event) {
        event.preventDefault();

        let formData = new FormData(event.target);


        let email = formData.get("email");
        let password = formData.get("password");

        if(email == "" || password == "") {
            return alert("Email and password are required!");
        }


        await login(email, password);
        ctx.updateUserNav();
        ctx.page.redirect("/")
    };

}



