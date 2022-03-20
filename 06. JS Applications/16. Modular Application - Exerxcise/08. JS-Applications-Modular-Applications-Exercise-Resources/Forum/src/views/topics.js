import { getAllTopics } from '../api/data.js'
import { spinner } from '../common/spinner.js';
import { html, until } from '../library.js'

let topicTemplate = (topicPromise) => html`
<h1>Topics</h1>
<div>
    ${until(topicPromise, spinner())}
</div>`;

let topicPreviewCard = (topic) => html `
<article class="preview">
        <header>
            <a href=${`/topic/${topic._id}`}>${topic.title}</a>
        </header>
        <div>
            <div>Comments: 23</div>
        </div>
    </article>`;

export function topicPage(ctx) {
    ctx.render(topicTemplate(loadTopics()));

};

async function loadTopics() {
   let topics = await getAllTopics();

   return topics.map(topicPreviewCard);
};