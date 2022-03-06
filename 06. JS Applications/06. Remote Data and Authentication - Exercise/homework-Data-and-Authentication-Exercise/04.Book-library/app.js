//x load all books
//x create books
//x delete books
//x edit books

//x processing create form
//processing edit form

//load book for editing
//x processing delete button
loadBooks();
let tBody = document.querySelector("tbody");
tBody.addEventListener("click", onTableClick);

let loadBooksBtn = document.getElementById("loadBooks");
loadBooksBtn.addEventListener("click", loadBooks);

let createForm = document.getElementById("createForm");
createForm.addEventListener("submit", onCreate);

let editForm = document.getElementById("editForm");
editForm.addEventListener("submit", onEditSubmit);

async function onEditSubmit(event) {
    event.preventDefault();
    let formDate = new FormData(editForm);

    let id = formDate.get("id");
    let author = formDate.get("author");
    let title = formDate.get("title");

    let result = await updateBook(id, {author, title});

    createForm.target.reset();
    createForm.style.display = "block";
    editForm.style.display = "none";

    loadBooks();

}

function onTableClick(event) {
    if (event.target.className === "delete") {
        onDelete(event.target);
    } else if (event.target.className === "edit") {
        onEdit(event.target);
    }
}

async function onEdit(button) {
    let id = button.parentElement.dataset.id;
    let book = await loadBookByID(id);

    createForm.style.display = "none";
    editForm.style.display = "block";

    //нямаме гаранция че в сървъра книгата ще има ID, затова взимаме текущото
    editForm.querySelector("[name=id]").value = id;


    editForm.querySelector("[name=author]").value = book.author;
    editForm.querySelector("[name=title]").value = book.title;
}

async function onDelete(button) {
    let id = button.parentElement.dataset.id;
    await deleteBook(id);
    //за да изтрием реда
    button.parentElement.parentElement.remove();
}

async function onCreate(event) {
    event.preventDefault();
    let formDate = new FormData(createForm);

    let author = formDate.get("author");
    let title = formDate.get("title");

    let result = await createBook({author, title});
    tBody.appendChild(createRow(result._id, result));
    createForm.reset();

}

function createRow(id, book) {
    let row = document.createElement("tr");
    row.innerHTML = `<td>${book.title}</td>
<td>${book.author}</td>
<td  data-id=${id}>
<button class="edit">Edit</button>
<button class="delete">Delete</button>
</td>`
    return row;
}

async function loadBooks() {
    let url = "http://localhost:3030/jsonstore/collections/books/";
    let books = await request(url);

    // с деструктуриране
    let result = Object.entries(books).map(([id, book]) => createRow(id, book));
    tBody.replaceChildren(...result);
}

async function loadBookByID(id) {
    let url = "http://localhost:3030/jsonstore/collections/books/" + id;
    let book = await request(url);
    return book;
}

async function createBook(book) {
    let url = "http://localhost:3030/jsonstore/collections/books/";
    let options = {
        method: "post",
        body: JSON.stringify(book)
    }
    let result = await request(url, options);
    return result;
}

async function updateBook(id, book) {
    let url = `http://localhost:3030/jsonstore/collections/books/${id}`;
    let options = {
        method: "put",
        body: JSON.stringify(book)
    }
    let result = await request(url, options);
    return result;
}

async function deleteBook(id) {
    let url = `http://localhost:3030/jsonstore/collections/books/${id}`;
    let options = {
        method: "delete"
    }
    let result = await request(url, options);
    return result;
}

async function request(url, options) {
    if (options && options.body !== undefined) {
        Object.assign(options, {
            headers: {
                "Content-Type": "application/json"
            }
        })
    }
    let response = await fetch(url, options);
    if (response.ok !== true) {
        let error = await response.json();
        alert(error.message);
        throw new Error(error.message)
    }
    let data = await response.json();
    return data;

}





