function search() {
    let elements = Array.from(document.querySelectorAll("ul li"));
    //за да вземем само текста
    let text = document.getElementById("searchText").value;

    let matches = 0;
    elements.forEach((el) => {
        if (el.textContent.includes(text)) {
            el.style.fontWeight = "bold";
            el.style.textDecoration = "underline";
            matches++;
        } else {
            el.style.fontWeight = "normal";
            el.style.textDecoration = "";
        }
    })

    document.getElementById("result").textContent =
        `${matches} matches found`;

}
