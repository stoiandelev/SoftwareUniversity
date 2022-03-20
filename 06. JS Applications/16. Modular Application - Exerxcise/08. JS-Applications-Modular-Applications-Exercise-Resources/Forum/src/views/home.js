import { getTopicCount } from '../api/data.js';
import { html, until } from '../library.js'

let homeTemplate = (countPromise) => html`
<h1>Wizard Home</h1>
<div class="splash">
    <p>Welcome to the Wizard Forum!</p>
    <div>
        <a href="/topics">Browse ${until(countPromise, "topics")}</a>
    </div>
</div>`;

export function homePage(ctx) {
    ctx.render(homeTemplate(loadHome()));

};

async function loadHome() {
    let count = await getTopicCount();
    return `${count} topics`;
}

