function create(words) {

    let content = document.getElementById("content");

    for (const word of words) {
        let div = document.createElement("div");
        let para = document.createElement("p");
        // ще бъде равно на текущата дума
        para.textContent = word;
        //невидим параграф
        para.style.display = "none";
        div.appendChild(para);
        div.addEventListener("click", reveal);
        content.appendChild(div);
    }

    function reveal(e) {
        e.currentTarget.firstChild.style.display = ""
    }

}