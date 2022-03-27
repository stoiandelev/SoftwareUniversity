import { register } from "../api/data.js";
import { html, render } from "../api/library.js";

let registerTemplate = (onRegister) => html`
<section id="register-page" class="content auth">
    <form @submit=${onRegister} id="register">
        <div class="container">
            <div class="brand-logo"></div>
            <h1>Register</h1>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="maria@email.com">

            <label for="pass">Password:</label>
            <input type="password" name="password" id="register-password">

            <label for="con-pass">Confirm Password:</label>
            <input type="password" name="confirm-password" id="confirm-password">

            <input class="btn submit" type="submit" value="Register">

            <p class="field">
                <span>If you already have profile click <a href="/login">here</a></span>
            </p>
        </div>
    </form>
</section>`;



export function registerPage(ctx) {
    ctx.render(registerTemplate(onRegister));

    async function onRegister(event) {
        event.preventDefault();

        let formData = new FormData(event.target);

        let email = formData.get("email");
        let password = formData.get("password");
        let rePass = formData.get("confirm-password");


        if (email == "" || password == "" || rePass == "") {
            return alert("All field are required!");
        }

        if (password != rePass) {
            return alert("Password don\`t match!");
        }


        await register(email, password);
        ctx.updateUserNav();
        ctx.page.redirect("/")
    };

}

