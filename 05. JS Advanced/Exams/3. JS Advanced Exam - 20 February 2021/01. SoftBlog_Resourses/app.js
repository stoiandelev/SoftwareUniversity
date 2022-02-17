function solve() {

    let createButton = document.querySelector(".site-content aside button.btn.create");
    createButton.addEventListener("click", createArticleHeader);


    function createArticleHeader(e) {
        e.preventDefault()

        let authorInput = document.querySelector("#creator");
        let titleInput = document.querySelector("#title");
        let categoryInput = document.querySelector("#category");
        let contentTextArea = document.querySelector("#content");

        let articleElement = document.createElement("article");

        let titleHeading = document.createElement("h1");
        titleHeading.textContent = titleInput.value;

        let categoryParagraph = document.createElement("p");
        categoryParagraph.textContent = "Category:";
        let categoryStrong = document.createElement("strong");
        categoryStrong.textContent = categoryInput.value;
        categoryParagraph.appendChild(categoryStrong);

        let creatorParagraph = document.createElement("p");
        creatorParagraph.textContent = "Creator:";
        let creatorStrong = document.createElement("strong");
        creatorStrong.textContent = authorInput.value;
        creatorParagraph.appendChild(creatorStrong);

        let contentParagraph = document.createElement("p");
        contentParagraph.textContent = contentTextArea.value;

        let buttonsDiv = document.createElement("div");
        buttonsDiv.classList.add("buttons");

        let deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.classList.add("btn", "delete");
        deleteButton.addEventListener("click", deleteArticleHandler);

        let archiveButton = document.createElement("button");
        archiveButton.textContent = "Archive";
        archiveButton.classList.add("btn", "archive");
        archiveButton.addEventListener("click", archiveArticleHandler);

        buttonsDiv.appendChild(deleteButton);
        buttonsDiv.appendChild(archiveButton);

        articleElement.appendChild(titleHeading);
        articleElement.appendChild(categoryParagraph);
        articleElement.appendChild(creatorParagraph);
        articleElement.appendChild(contentParagraph);
        articleElement.appendChild(buttonsDiv);

        let postSection = document.querySelector(".site-content main section")
        postSection.appendChild(articleElement);

    }

    function deleteArticleHandler(e) {
        let deleteButton = e.target;
        let articleToDelete = deleteButton.parentElement.parentElement;
        articleToDelete.remove();
    }

    function archiveArticleHandler(event) {
        let articleToArchive = event.target.parentElement.parentElement;


        let archiveOl = document.querySelector(".archive-section ol");

        let archiveList = Array.from(archiveOl.querySelectorAll("li"));
        let articleTitleHeading = articleToArchive.querySelector("h1");
        let articleTitle = articleTitleHeading.textContent;


        let newTitleLi = document.createElement("li");
        newTitleLi.textContent = articleTitle;

        //след като отиде в архива да се премахне
        articleToArchive.remove();


        archiveList.push(newTitleLi);
        archiveList
            .sort((a, b) => {
                    a.textContent.localeCompare(b.textContent)
                }
            )
            .forEach(li => archiveOl.appendChild(li));


    }
}
