let element = document.getElementById("errorBox");
let output = element.querySelector("span");

export function notify(msg) {
    output.textContent = msg;
    element.style.display = "block";

    setTimeout(() => element.style.display = "none", 3000);
};

