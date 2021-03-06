import { searchBooks } from "../api/data.js";
import { html, render } from "../api/library.js";

let searchTemplate = (books, onSearch, params = "") => html`
<section id="search-page" class="dashboard">
    <h1>Search</h1>

    <form @submit = ${onSearch}>
        <input type="text" name="search" .value=${params}>
        <input type="submit" value="Search">
    </form>



    ${books.length == 0
     ? html` <p class="no-books">No results!</p>`
     : html`<ul class="other-books-list">
    ${books.map(bookPreview)}</ul>`}

   
</section>`;

let bookPreview = (book) => html`
<li class="otherBooks">
    <h3>${book.title}</h3>
    <p>Type: ${book.type}</p>
    <p class="img"><img src=${book.imageUrl}></p>
    <a class="button" href="/details/${book._id}">Details</a>
</li>`;


export async function searchPage(ctx) {
    let params = ctx.querystring.split('=')[1];
    let books = [];

    if(params) {
        books = await searchBooks(decodeURIComponent(params));
    }
    

    ctx.render(searchTemplate(books, onSearch, params));

    function onSearch(event) {
        event.preventDefault();

        let formData = new FormData(event.target);
        let search = formData.get("search");
       
        if(search) {
            // @ts-ignore
            ctx.page.redirect("/search?query=" + encodeURIComponent(search));
        };



    }
}
