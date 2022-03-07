// initialization
// find section
// detach section from DOM

import { showView } from "./dom.js";

// display login

let section = document.getElementById("edit-movie");
section.remove();

export function showEdit() {
    showView(section);
};


