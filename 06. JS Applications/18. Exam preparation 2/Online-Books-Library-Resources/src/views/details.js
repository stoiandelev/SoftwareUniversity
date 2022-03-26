import { deleteBook, getBookById, getLikesByBookId, getMyLikeByBookId, newLikeBook } from "../api/data.js";
import { html, render } from "../api/library.js";
import { getUserData } from "../api/util.js";

let detailsTemplate = (book, isOwner, onDelete, likes, showLikeBtn, onLike) => html`
<section id="details-page" class="details">
    <div class="book-information">
        <h3>${book.title}</h3>
        <p class="type">Type: ${book.type}</p>
        <p class="img"><img src=${book.imageUrl}></p>
        <div class="actions">

            ${bookControlsTemplate(book, isOwner, onDelete)};

            ${likeControlsTemplate(showLikeBtn, onLike)};


            <div class="likes">
                <img class="hearts" src="/images/heart.png">
                <span id="total-likes">Likes: ${likes}</span>
            </div>


        </div>
    </div>
    <div class="book-description">
        <h3>Description:</h3>
        <p>${book.description}</p>
    </div>
</section>`;

let bookControlsTemplate = (book, isOwner, onDelete) => {
    if (isOwner) {
        return html`
        <a class="button" href="/edit/${book._id}">Edit</a>
        <a @click=${onDelete} class="button" href="javascript:void(0)">Delete</a>`;
    } else {
        return null;
    }
}

let likeControlsTemplate = (showLikeBtn, onLike) => {
    if (showLikeBtn) {
        //<!-- Like button ( Only for logged-in users, which is not creators of the current book ) -->
        return html`<a @click=${onLike} class="button" href="javascript:void(0)">Like</a>`
    } else {
        return null;
    };
};



export async function detailsPage(ctx) {
    let userData = getUserData();

    let [book, likes, hasLike] = await Promise.all([
        getBookById(ctx.params.id),
        getLikesByBookId(ctx.params.id),
        userData ? getMyLikeByBookId(ctx.params.id, userData.id) : 0
    ]);




    let isOwner = userData && book._ownerId == userData.id;
    let showLikeBtn = userData != null && isOwner == false && hasLike == false;

    ctx.render(detailsTemplate(book, isOwner, onDelete, likes, showLikeBtn, onLike));

    async function onDelete() {
        let choice = confirm(`Are you sure you want to delete ${book.title}?`);

        if (choice) {
            await deleteBook(ctx.params.id);
            ctx.page.redirect("/");
        }
    }

    async function onLike() {
        
        await newLikeBook(ctx.params.id);
        ctx.page.redirect("/details/" + ctx.params.id);
    };

}
