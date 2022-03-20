import { html } from '../library.js'
import { createSubmitHeader } from "../api/util.js";
import { login } from '../api/api-crud.js';

let loginTemplate = (onSubmit, errorMsg, email) => html`
<div class="narrow center">
    <header>
        <h1>Login</h1>
    </header>
    <form @submit=${onSubmit}>
        ${errorMsg ? html`<p class="error-msg">${errorMsg}</p>` : null}
        <label><span>Email</span><input type="text" name="email" .value=${email}></label>
        <label><span>Password</span> <input type="password" name="password"></label>
        <input class="action" type="submit" value="Sign in">
    </form>
</div>`;

export function loginPage(ctx) {
    update();

    function update(errorMsg = "", email = "") {
        ctx.render(loginTemplate(createSubmitHeader(onSubmit, "email","password"),
            errorMsg,
             email
             ));
    };

    async function onSubmit(data) {
        try {
            await login(data.email, data.password);
            ctx.updateUserNav();
            ctx.page.redirect("/topics");
        } catch (err) {
            let message = err.message || err.error.message;
            update(message, data.email);
        };

    };

};



