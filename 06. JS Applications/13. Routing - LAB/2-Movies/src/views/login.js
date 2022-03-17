import { login } from "../api/data.js";
import { html, render } from "../lib.js";

let loginTemplate = (onSubmit) => html`
        <section id="form-login">
            <form @submit=${onSubmit} class="text-center border border-light p-5" action="" method="">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input id="email" type="text" class="form-control" placeholder="Email" name="email" value="">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" class="form-control" placeholder="Password" name="password" value="">
                </div>
        
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </section>`;


export function loginPage(ctx) {
    ctx.render(loginTemplate(onSubmit));

    async function onSubmit(event) {
        event.preventDefault();
        let formData = new FormData(event.target);

        let email = formData.get("email");
        let password = formData.get("password");

        await login (email, password);
        ctx.updateUserNav();
        ctx.page.redirect("/home"); 
    };
};

