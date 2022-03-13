import { deleteById, getIdeaById } from '../api/data.js';
import { e, showSection } from '../src/dom.js'


let section = document.getElementById("detailsPage");
section.remove();

let ctx = null;
export async function showDetailsPage(ctxTarget, id) {
    ctx = ctxTarget;
    ctx.showSection(section);
    loadIdea(id);
};

async function loadIdea(id) {
    let idea = await getIdeaById(id);
    section.replaceChildren(createIdeaDiv(idea));
};

function createIdeaDiv(idea) {
    let fragment = document.createDocumentFragment();
    fragment.appendChild(e("img", { className: "det-img", src: idea.img }));
    fragment.appendChild(e("div", { className: "desc" },
        e("h2", { className: "display-5" }, idea.title),
        e("p", { className: "infoType" }, "Description:"),
        e("p", { className: "idea-description" }, idea.description))
    );

    let userData = JSON.parse(sessionStorage.getItem("userData"));

    if (userData && userData.id == idea._ownerId) {
        fragment.appendChild(e("div", { className: "text-center" },
            e("a", { className: "btn detb", href: "", onClick: onDelete }, "Delete")
        ));
    };

    return fragment;

    async function onDelete(event) {
        event.preventDefault();
        let confirmed = confirm("Are you sure you want to delete this idea?");
        if (confirmed) {
            await deleteById(idea._id);
            ctx.goTo("catalog");
        };
    }
};



