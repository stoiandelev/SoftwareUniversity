// @ts-nocheck
import { login } from "../api/data.js";
import { html, render } from "../api/library.js";


let loginTemplate = (onLogin) => html`
<section id="login-page" class="login">
    <form @submit=${onLogin} id="login-form" action="" method="">
        <fieldset>
            <legend>Login Form</legend>
            <p class="field">
                <label for="email">Email</label>
                <span class="input">
                    <input type="text" name="email" id="email" placeholder="Email">
                </span>
            </p>
            <p class="field">
                <label for="password">Password</label>
                <span class="input">
                    <input type="password" name="password" id="password" placeholder="Password">
                </span>
            </p>
            <input class="button submit" type="submit" value="Login">
        </fieldset>
    </form>
</section>`;




export function loginPage(ctx) {
    ctx.render(loginTemplate(onLogin));

    async function onLogin(event) {
        event.preventDefault();

        let formData = new FormData(event.target);

        let email = formData.get("email").trim();
        let password = formData.get("password").trim();

        if(email == "" || password == "") {
            return alert("Email and password are required!");
        }


        await login(email, password);
        ctx.updateUserNav();
        ctx.page.redirect("/")
    };

}
