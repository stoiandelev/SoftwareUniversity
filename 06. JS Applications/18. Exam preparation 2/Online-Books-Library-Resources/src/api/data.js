import * as api from './api-crud.js';

export let login = api.login;
export let register = api.register;
export let logout = api.logout;

const endpoint = {
    allBooks: '/data/books?sortBy=_createdOn%20desc',
    bookById: "/data/books/",
    createBook: "/data/books",
    editBook: "/data/books/",
    deleteBook: "/data/books/",
    myBooks: (userId) => `/data/books?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`,
    newLikeBook: "/data/likes",
    getLikesByBook: (bookId) => `/data/likes?where=bookId%3D%22${bookId}%22&distinct=_ownerId&count`,
    getMyLikeByBookId: (bookId, userId) => `/data/likes?where=bookId%3D%22${bookId}%22%20and%20_ownerId%3D%22${userId}%22&count`

};


export async function getAllBooks() {
    return api.get(endpoint.allBooks);
};

export async function getBookById(id) {
    return api.get(endpoint.bookById + id);
};

export async function createBook(book) {
    return api.post(endpoint.createBook, book);
};

export async function editBook(id, book) {
    return api.put(endpoint.editBook + id, book);
};

export async function deleteBook(id) {
    return api.del(endpoint.deleteBook + id);
};

export async function getMyBooks(userId) {
    return api.get(endpoint.myBooks(userId));
};

// all function for Like

export async function newLikeBook(bookId) {
    return api.post(endpoint.newLikeBook, {
        bookId
    });
};

export async function getLikesByBookId(bookId) {
    return api.get(endpoint.getLikesByBook(bookId));
};

export async function getMyLikeByBookId(bookId, userId) {
    return api.get(endpoint.getMyLikeByBookId(bookId, userId));
};

// function for Search

export async function searchBooks(query) {
    return api.get("/data/books?where=" + encodeURIComponent(`title LIKE "${query}"`));
}








