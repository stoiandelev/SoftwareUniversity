import { showSection } from "./dom.js";


let homeSection = document.getElementById("homeSection");
homeSection.remove();

let aboutSection = document.getElementById("aboutSection");
aboutSection.remove();


 
export function showHomePage(){
    showSection(homeSection)
};

export function showAboutPage(){
    showSection(aboutSection)
};