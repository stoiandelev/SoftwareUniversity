// @ts-nocheck
import { register } from "../api/data.js";
import { html, render } from "../api/library.js";


let registerTemplate = (onRegister) => html`
<section id="register-page" class="register">
    <form @submit=${onRegister} id="register-form" action="" method="">
        <fieldset>
            <legend>Register Form</legend>
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
            <p class="field">
                <label for="repeat-pass">Repeat Password</label>
                <span class="input">
                    <input type="password" name="confirm-pass" id="repeat-pass" placeholder="Repeat Password">
                </span>
            </p>
            <input class="button submit" type="submit" value="Register">
        </fieldset>
    </form>
</section>`;




export function registerPage(ctx) {
    ctx.render(registerTemplate(onRegister));

    async function onRegister(event) {
        event.preventDefault();

        let formData = new FormData(event.target);

        let email = formData.get("email").trim();
        let password = formData.get("password").trim();
        let rePass = formData.get("confirm-pass").trim();


        if (email == "" || password == "" || rePass == "") {
            return alert("All field are required!");
        }

        if (password != rePass ) {
            return alert("Password don\`t match!");
        }


        await register(email, password);
        ctx.updateUserNav();
        ctx.page.redirect("/")
    };

}
