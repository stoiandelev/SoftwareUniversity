import { getUserData } from "./util.js";

function updateUserNav() {
    let userData = getUserData();

    if (userData) {
        // @ts-ignore
        document.querySelector(".user").style.display = "inline-block";
        // @ts-ignore
        document.querySelector(".guest").style.display = "none";
    } else {
        // @ts-ignore
        document.querySelector(".user").style.display = "none";
        // @ts-ignore
        document.querySelector(".guest").style.display = "inline-block";
    }
};