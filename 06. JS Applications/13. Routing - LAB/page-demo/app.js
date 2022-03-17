import page from "./node_modules/page/page.mjs";


function homePage() {
    main.innerHTML = `<h2>Home Page</h2><p>Welcome to our site!</p>`;
};

function catalogPage() {
    main.innerHTML = `<h2>Catalog</h2><p>List of items</p><a href="/catalog">button</a>`;
};

function aboutPage() {
    main.innerHTML = `<h2>About us</h2><p>Contact: 1-345-333-444</p>`;
};

function checkOutPage() {
    main.innerHTML = `<h2>Card details</h2><p>Products in card</p>`;
};

function detailsPage(ctx) {
    console.log(ctx);
    main.innerHTML = `<h2>Product</h2><p>Product details</p><button>Buy now</button></>`;
    document.querySelector("button").addEventListener("click", () => {
        page.redirect("/checkOutPage");
    });
};

let views = {
    "/catalog/kitchen": () => `<h2>Kitchen Equipment</h2><p>List of items</p>`,

};

let main = document.querySelector("main");

page("/home", homePage);
page("/catalog", catalogPage);
page("/catalog/:id", detailsPage);
page("/about", aboutPage);
page("/checkOutPage", checkOutPage);

page.redirect("/", "home");

page.start();
