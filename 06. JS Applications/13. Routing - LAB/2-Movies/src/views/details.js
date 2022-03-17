import { html, render, until } from "../lib.js";
import { getUserData } from "../../src/util.js";

let detailsTemplate = (moviePromise) => html`
${until(moviePromise, html`<p>Loading &hellip;</p>`)}

</section>`;

let movieTemplateDetails = (movie) => html`
<section id="movie-example">
    <div class="container">
        <div class="row bg-light text-dark">
            <h1>Movie title: ${movie.title}</h1>

            <div class="col-md-8">
                <img class="img-thumbnail" src=${movie.img} alt="Movie">
            </div>
            <div class="col-md-4 text-center">
                <h3 class="my-3 ">Movie Description</h3>
                <p>${movie.description}</p>

                ${movie.isOwned
                     ? html`
                        <a class="btn btn-danger" href="#">Delete</a>
                        <a class="btn btn-warning" href=${`/edit/${movie._id}`}>Edit</a>` 
                     : html `<a class="btn btn-primary" href="#">Like</a>`}

                <span class="enrolled-span">Liked 1</span>
            </div>
        </div>
    </div>
</section>`;

export function detailsPage(ctx) {
    ctx.render(detailsTemplate(loadMovie(ctx)));
};

async function loadMovie(ctx) {
    let movie = await ctx.moviePromise;

    let userData = getUserData();
    if (userData && userData.id == movie._ownerId) {
        movie.isOwned = true;
    };

    return movieTemplateDetails(movie);
};  