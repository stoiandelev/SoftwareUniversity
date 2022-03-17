import { html, render, until } from "../lib.js";

let editTemplate = (moviePromise) => html`
<section id="edit-movie">
    ${until(moviePromise, html`<p>Loading &hellip;</p>`)}
</section>`;

let formTemplate = (movie, onSubmit) => html`
<form class="text-center border border-light p-5" action="#" method="">
    <h1>Edit Movie</h1>
    <div class="form-group">
        <label for="title">Movie Title</label>
        <input id="title" type="text" class="form-control" placeholder="Movie Title" .value=${movie.title} name="title">
    </div>
    <div class="form-group">
        <label for="description">Movie Description</label>
        <textarea class="form-control" placeholder="Movie Description..." name="description" .value=${movie.description}></textarea>
    </div>
    <div class="form-group">
        <label for="imageUrl">Image url</label>
        <input id="imageUrl" type="text" class="form-control" placeholder="Image Url" .value=${movie.img} name="imageUrl">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>`;


export function editPage(ctx) {
    ctx.render(editTemplate(loadMovies(ctx)));
};

async function loadMovies(ctx) {
    let movie = await ctx.moviePromise;

    return formTemplate(movie, onSubmit)
    async function onSubmit(event)  {
        
    };
};