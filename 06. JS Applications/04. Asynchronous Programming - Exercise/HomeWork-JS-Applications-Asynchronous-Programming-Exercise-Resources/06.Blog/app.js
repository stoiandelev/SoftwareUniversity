function attachEvents() {
    let loadPostBTN = document.getElementById("btnLoadPosts");
    loadPostBTN.addEventListener("click", getAllPost);

    let viewPostBTN = document.getElementById("btnViewPost");
    viewPostBTN.addEventListener("click", displayPost);


}

attachEvents();

async function displayPost() {
    let titleElement = document.getElementById("post-title");
    let bodyElement = document.getElementById("post-body");
    let ulElement = document.getElementById("post-comments");

    titleElement.textContent = "Loading...";
    bodyElement.textContent = "";
    ulElement.replaceChildren();

    let selectedID = document.getElementById("posts").value;

    let [post, comments] = await Promise.all([
        getPostByID(selectedID),
        getCommentsByPostId(selectedID)
    ])

    titleElement.textContent = post.title;

    bodyElement.textContent = post.body;
    comments.forEach(c => {
        let liElement = document.createElement("li");
        liElement.textContent = c.text;
        ulElement.appendChild(liElement);
    })

}

async function getAllPost() {
    let url = `http://localhost:3030/jsonstore/blog/posts`;
    let response = await fetch(url);
    let data = await response.json();

    let selectElement = document.getElementById("posts");
    selectElement.replaceChildren();
    Object.values(data).forEach(p => {
        let optionElement = document.createElement("option");
        optionElement.textContent = p.title;
        optionElement.value = p.id;
        selectElement.appendChild(optionElement);
    })

}

async function getPostByID(postId) {
    let url = `http://localhost:3030/jsonstore/blog/posts/` + postId;
    let response = await fetch(url);
    let data = await response.json();

    return data;

}

async function getCommentsByPostId(postId) {
    let url = `http://localhost:3030/jsonstore/blog/comments`;
    let response = await fetch(url);
    let data = await response.json();

    let comments = Object.values(data).filter(c => c.postId === postId);

    return comments;
}