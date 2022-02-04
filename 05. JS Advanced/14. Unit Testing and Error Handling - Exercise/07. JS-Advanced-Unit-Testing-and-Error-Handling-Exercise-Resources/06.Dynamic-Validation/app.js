function validate() {
    let inputField = document.getElementById("email");

    let validMailPattern = /(^[a-z]+@[a-z]+\.[a-z]+$)/;

    inputField.addEventListener("change", () => {
        if (!validMailPattern.test(inputField.value)) {
            inputField.classList.add("error");
        } else {
            inputField.classList.remove("error");
        }
    })
}