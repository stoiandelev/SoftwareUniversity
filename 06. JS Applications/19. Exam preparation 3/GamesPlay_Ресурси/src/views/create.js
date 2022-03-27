import { createGame, getAllGames, getHomePage } from "../api/data.js";
import { html, render } from "../api/library.js";

let createTemplate = (onCreate) => html`
<section id="create-page" class="auth">
    <form @submit=${onCreate} id="create">
        <div class="container">

            <h1>Create Game</h1>
            <label for="leg-title">Legendary title:</label>
            <input type="text" id="title" name="title" placeholder="Enter game title...">

            <label for="category">Category:</label>
            <input type="text" id="category" name="category" placeholder="Enter game category...">

            <label for="levels">MaxLevel:</label>
            <input type="number" id="maxLevel" name="maxLevel" min="1" placeholder="1">

            <label for="game-img">Image:</label>
            <input type="text" id="imageUrl" name="imageUrl" placeholder="Upload a photo...">

            <label for="summary">Summary:</label>
            <textarea name="summary" id="summary"></textarea>
            <input class="btn submit" type="submit" value="Create Game">
        </div>
    </form>
</section>`;



export function createPage(ctx) {
    ctx.render(createTemplate(onCreate));

    async function onCreate(event) {
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


        await createGame({
            title,
            category,
            maxLevel,
            imageUrl,
            summary

        });
        ctx.page.redirect("/")
    };

}


