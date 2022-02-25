window.addEventListener('load', solve);

function solve() {

    let genreField = document.querySelector("#genre");
    let nameOfTheSongField = document.querySelector("#name");
    let authorField = document.querySelector("#author");
    let dateField = document.querySelector("#date");
    let addButton = document.querySelector("#add-btn");

    let totalLikes = 0;

    addButton.addEventListener("click", collectionOfSongs);

    function collectionOfSongs(e) {
        e.preventDefault();

        let genre = genreField.value;
        let nameOfSong = nameOfTheSongField.value;
        let author = authorField.value;
        let date = dateField.value;


        if (genre === "" || nameOfSong === "" || author === "" || date === "") {
            return;
        }

        genreField.value = "";
        nameOfTheSongField.value = "";
        authorField.value = ""
        dateField.value = "";

        let divAllHits = document.querySelector(".all-hits-container");
        let saveBtn = ev("button", {className: "save-btn"}, "Save song");
        let likeBtn = ev("button", {className: "like-btn"}, "Like song");
        let deleteBtn = ev("button", {className: "delete-btn"}, "Delete");

        let div = ev("div", {className: "hits-info"},
            ev("img", {src: "./static/img/img.png"}),
            ev("h2", {}, `Genre: ${genre}`),
            ev("h2", {}, `Name: ${nameOfSong}`),
            ev("h2", {}, `Author: ${author}`),
            ev("h3", {}, `Date: ${date}`),
            saveBtn,
            likeBtn,
            deleteBtn
        );

        divAllHits.appendChild(div);

        likeBtn.addEventListener("click", () => {
            totalLikes += 1;
            likeBtn.disabled = true;
            let likesCounter = document.querySelector("#total-likes p");
            likesCounter.textContent = `Total Likes: ${totalLikes}`;
        });

        saveBtn.addEventListener("click", () => {
            let divSavedHits = document.querySelector(".saved-container");
            divSavedHits.appendChild(div);
            saveBtn.remove();
            likeBtn.remove();
        });

        deleteBtn.addEventListener("click", () => {
            div.remove();
        })

    }


    function ev(type, attributes, ...content) {
        const result = document.createElement(type);
        for (let [attr, value] of Object.entries(attributes || {})) {
            if (attr.substring(0, 2) === 'on') {
                result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
            } else {
                result[attr] = value;
            }
        }
        content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);
        content.forEach(e => {
            if (typeof e == 'string' || typeof e == 'number') {
                const node = document.createTextNode(e);
                result.appendChild(node);
            } else {
                result.appendChild(e);
            }
        });
        return result;
    }


}


