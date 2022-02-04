function notify(message) {
    let resultDiv = document.querySelector("#notification");
    resultDiv.style.display = "block";
    resultDiv.textContent = message;

    // при клик да се скрива.
    resultDiv.addEventListener("click",()=> {
        resultDiv.style.display = "none";
    }
)
}