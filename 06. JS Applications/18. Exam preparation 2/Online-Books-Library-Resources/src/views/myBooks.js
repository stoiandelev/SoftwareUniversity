import { getMyBooks } from "../api/data.js";
import { html, render } from "../api/library.js";
import { getUserData } from "../api/util.js";


let myBooksTemplate = (books) => html`
<section id="my-books-page" class="my-books">
    <h1>My Books</h1>
    
    <!-- Display ul: with list-items for every user's books (if any) -->
     <!-- Display paragraph: If the user doesn't have his own books  -->
    
    ${books.length == 0
            ?
            html`<p class="no-books">No books in database!</p>`
            :
            html`<ul class="my-books-list">
                ${books.map(bookCard)};
            </ul>`}
            
   
</section>`;

let bookCard = (book) => html`
<li class="otherBooks">
    <h3>${book.title}</h3>
    <p>Type: ${book.type}</p>
    <p class="img"><img src=${book.imageUrl}></p>
    <a class="button" href="/details/${book._id}">Details</a>
</li>`;




export async function myBooksPage(ctx) {
    let userData = getUserData();
    let books = await getMyBooks(userData.id);

    ctx.render(myBooksTemplate(books));

}
