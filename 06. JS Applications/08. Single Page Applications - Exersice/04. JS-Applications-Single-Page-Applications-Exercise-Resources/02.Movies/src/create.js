// initialization
// find section
// detach section from DOM

import { showView } from "./dom.js";

// display login

let section = document.getElementById("add-movie");
section.remove();

export function showCreate() {
    showView(section);
};


