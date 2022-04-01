import { e, showSection } from '../src/dom.js'


let section = document.getElementById("homePage");
section.remove();

let ctx = null;

section.querySelector("#getStartedLink").addEventListener("click", (event) => {
    event.preventDefault();
    ctx.goTo("catalog")
});

export async function showHomePage(ctxTarget) {
    ctx = ctxTarget
    ctx.showSection(section);
};







