import { createGame, editGame, getAllGames, getGameById, getHomePage } from "../api/data.js";
import { html, render } from "../api/library.js";

let editTemplate = (game, onEdit) => html`
<section id="edit-page" class="auth">
    <form @submit=${onEdit} id="edit">
        <div class="container">

            <h1>Edit Game</h1>
            <label for="leg-title">Legendary title:</label>
            <input type="text" id="title" name="title" .value=${game.title}>

            <label for="category">Category:</label>
            <input type="text" id="category" name="category" .value=${game.category}>

            <label for="levels">MaxLevel:</label>
            <input type="number" id="maxLevel" name="maxLevel" min="1" .value=${game.maxLevel}>

            <label for="game-img">Image:</label>
            <input type="text" id="imageUrl" name="imageUrl" .value=${game.imageUrl}>

            <label for="summary">Summary:</label>
            <textarea name="summary" id="summary" .value=${game.summary}></textarea>
            <input class="btn submit" type="submit" >

        </div>
    </form>
</section>`;



export async function editPage(ctx) {
    let game = await getGameById(ctx.params.id);


    ctx.render(editTemplate(game, onEdit));

    async function onEdit(event) {
        event.preventDefault();

        let formData = new FormData(event.target);

        let title = formData.get("title");
        let category = formData.get("category");
        let maxLevel = formData.get("maxLevel");
        let imageUrl = formData.get("imageUrl");
        let summary = formData.get("summary");

        if (title == "" || category == "" || maxLevel == "" || imageUrl == "" || summary == "") {
            return alert("All fields are required!");
        }


        await editGame(ctx.params.id,{
            title,
            category,
            maxLevel,
            imageUrl,
            summary

        });
        ctx.page.redirect("/details/" + ctx.params.id)
    };

}


