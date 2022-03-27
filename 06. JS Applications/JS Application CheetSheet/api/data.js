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
    myBooks: (userId) => `/data/books?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`
    
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

export async function deleteItem(id) {
    return api.del(endpoint.deleteBook + id);
};

export async function getMyBooks(userId) {
    return api.get(endpoint.myBooks(userId));
};






