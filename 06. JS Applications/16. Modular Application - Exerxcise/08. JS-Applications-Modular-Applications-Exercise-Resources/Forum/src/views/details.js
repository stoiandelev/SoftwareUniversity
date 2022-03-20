import { getTopicById } from '../api/data.js';
import { spinner } from '../common/spinner.js';
import { html, until } from '../library.js'

let detailsTemplate = (topicPromise) => html`
<div class="drop main">
    ${until(topicPromise, spinner())}

</div>`;

let topicCard = (topic) => html`
<header>
    <h1>${topic.tile}</h1>
</header>
<p>
    ${topic.content}</p>
</p>`;


export function detailsPage(ctx) {
    ctx.render(detailsTemplate(loadTopic(ctx.params.id)));

};

async function loadTopic(id) {
    let topic = await getTopicById(id);
    return topicCard(topic);
}

