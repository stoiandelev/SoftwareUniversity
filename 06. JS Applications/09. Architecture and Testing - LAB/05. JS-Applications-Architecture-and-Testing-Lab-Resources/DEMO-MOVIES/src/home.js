
let homeSection = document.getElementById("homeSection");
homeSection.remove();

let aboutSection = document.getElementById("aboutSection");
aboutSection.remove();


 
export function showHomePage(ctx){
   ctx.showSection(homeSection)
};

export function showAboutPage(ctx){
    ctx.showSection(aboutSection)
};