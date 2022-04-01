import { createIdea } from '../api/data.js';


let section = document.getElementById("createPage");
section.remove();

let form = section.querySelector("form");
form.addEventListener("submit", onSubmit);
let ctx = null;

export async function showCreatePage(ctxTarget) {
    ctx = ctxTarget;
    ctx.showSection(section);
};

async function onSubmit(event) {
    event.preventDefault();
    let formData = new FormData(form);
    let title = formData.get("title").trim();
    let description = formData.get("description").trim();
    let img = formData.get("imageURL").trim();

    if (title.length < 6) {
        return alert("Title must be at least 6 characters long.");
    };

    if (description.length < 10) {
        return alert("Description must be at least 10 characters long.");
    };

    if (img.length < 5) {
        return alert("Image must be at least 5 characters long.");
    };

    createIdea( {title, description, img} );
    form.reset();
    ctx.goTo("catalog");

};





