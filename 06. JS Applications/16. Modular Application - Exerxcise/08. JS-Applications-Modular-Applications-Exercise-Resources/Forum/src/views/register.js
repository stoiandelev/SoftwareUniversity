import { createSubmitHeader } from '../api/util.js';
import { html } from '../library.js'
import { input } from '../common/input.js';
import { register } from "../../src/api/data.js";

let registerTemplate = (onSubmit, errorMsg, errors, values) => html`
<div class="narrow center">
    <header>
        <h1>Register</h1>
    </header>
    <form @submit=${onSubmit}>
        ${errorMsg ? html`<p class="error-msg">${errorMsg}</p>` : null}
        ${input("Email", "text", "email", values.email, errors.email)}
        ${input("Display name", "text", "username", values.username, errors.username)}
        ${input("Password", "password", "password", values.password, errors.password)}
        ${input("Repeat", "password", "repass", values.repass, errors.repass)}

        <input class="action" type="submit" value="Sign up">
    </form>
</div>`;

export function registerPage(ctx) {
    update();

    function update(errorMsg, errors = {}, values = {}) {
        ctx.render(registerTemplate(createSubmitHeader(
            onSubmit,
            "email",
            "username",
            "password",
            "repass"), errorMsg, errors, values));
    };

    async function onSubmit(data, event) {
        try {
            let missing = Object.entries(data).filter(([k, v]) => v == "");
            if (missing.length > 0) {
                let errors = missing.reduce((acc, [k]) => Object.assign(acc, { [k]: true }), {});
                throw {
                    error: new Error("All fields are required!"),
                    errors
                };
            };

            if (data.password != data.repass) {
                throw {
                    error: new Error("Password don`t match!"),
                    errors: {
                        password: true,
                        repass: true
                    }
                };
            };

            await register(data.email, data.username, data.password);
            event.target.reset();
            ctx.updateUserNav();
            ctx.page.redirect("/topics");


        } catch (err) {
            let message = err.message || err.error.message;
            update(message, err.errors, data);
        };
    };
};

