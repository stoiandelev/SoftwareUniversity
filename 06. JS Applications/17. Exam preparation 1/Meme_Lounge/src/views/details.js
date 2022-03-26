import { deleteMeme, getMemeById } from "../api/data.js";
import { html } from "../api/library.js";
import { getUserData } from "../api/util.js";

let detailsTemplate = (meme, isOwner, onDelete) => html`
<section id="meme-details">
    <h1>Meme Title: ${meme.title}</h1>
    <div class="meme-details">
        <div class="meme-img">
            <img alt="meme-alt" src=${meme.imageUrl}>
        </div>
        <div class="meme-description">
            <h2>Meme Description</h2>
            <p> ${meme.description} </p>

            <!-- Buttons Edit/Delete should be displayed only for creator of this meme  -->
            ${ isOwner
                ? html`     <a class="button warning" href="/edit/${meme._id}">Edit</a>
                            <button @click=${onDelete} class="button danger">Delete</button>`
                : null}
    
        </div>
    </div>
</section>`;


export async function detailsPage(ctx) {
    let meme = await getMemeById(ctx.params.id)

    //user is owner on publication
    let userData = getUserData();
    let isOwner = userData && meme._ownerId == userData.id;

    ctx.render(detailsTemplate(meme, isOwner, onDelete));

    async function onDelete() {
        let choice = confirm("Are you sure you want to delete this meme?");

        if(choice) {
            await deleteMeme(ctx.params.id);
            ctx.page.redirect("/memes");
        }
    }
};




