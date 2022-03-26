import { getMyMemes } from "../api/data.js";
import { html } from "../api/library.js";
import { getUserData } from "../api/util.js";

let profileTemplate = (memes, userData) => html`
<section id="user-profile-page" class="user-profile">
    <article class="user-info">
        <img id="user-avatar-url" alt="user-profile" src="/images/${userData.gender}.png">
        <div class="user-content">
            <p>Username: ${userData.username}</p>
            <p>Email: ${userData.email}</p>
            <p>My memes count: ${memes.length}</p>
        </div>
    </article>
    <h1 id="user-listings-title">User Memes</h1>
    <div class="user-meme-listings">
        <!-- Display : All created memes by this user (If any) -->
         ${memes.length == 0
            ?
            html`<p class="no-memes">No memes in database.</p>`
            :
            memes.map(memeCard)};
        

        
        <!-- Display : If user doesn't have own memes  -->
    </div>
</section>`;

let memeCard = (meme) => html`
<div class="user-meme">
    <p class="user-meme-title">${meme.title}</p>
    <img class="userProfileImage" alt="meme-img" src=${meme.imageUrl}>
    <a class="button" href="/details/${meme._id}">Details</a>
</div>`;


export async function profilePage(ctx) {
    let userData = getUserData();


    let memes = await getMyMemes(userData.id);
    ctx.render(profileTemplate(memes, userData));
};

