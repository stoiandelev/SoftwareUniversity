import { html, render } from "../node_modules/lit-html/lit-html.js";
import { until } from "../node_modules/lit-html/directives/until.js"

let host = "http://localhost:3030/jsonstore/collections";


export {
    html,
    render,
    until
};

async function request(url, method = "GET", data) {
    let option = {
        method,
        headers: {}
    };

    if (data !== undefined) {
        option.headers["Content-Type"] = "application/json";
        option.body = JSON.stringify(data);
    }

    let response = await fetch(host + url, option);

    if (response.ok == false) {
        let error = await response.json();
        alert(error.message);
        throw new Error(error.message);
    }

    return response.json();
}

export async function getBooks() {
    return request("/books/");
}

export async function getById(id) {
    return request("/books/" + id);
}

export async function createBook(book) {
    return request("/books/", "post", book);
}

export async function updateBooks(id, book) {
    return request("/books/" + id, "put", book);
}

export async function deleteBooks(id) {
    return request("/books/" + id, "delete");
}