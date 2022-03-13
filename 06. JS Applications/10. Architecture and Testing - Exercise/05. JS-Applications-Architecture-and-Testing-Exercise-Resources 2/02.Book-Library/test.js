let { chromium, firefox } = require("playwright-chromium");
let { expect } = require("chai");

let mockData = {
    "d953e5fb-a585-4d6b-92d3-ee90697398a0": {
        "author": "J.K.Rowling",
        "title": "Harry Potter and the Philosopher's Stone"
    },
    "d953e5fb-a585-4d6b-92d3-ee90697398a1": {
        "author": "Svetlin Nakov",
        "title": "C# Fundamentals"
    }
};

function json(data) {
    return {
        status: 200,
        headers: {
            "Access-Control-Allow-Origin": "*",
            "ContentType": "Application/json"
        },
        body: JSON.stringify(data)
    };
};


describe("Test", async function () {
    this.timeout(6000);
    let page, browser;
    before(async () => {
        browser = await firefox.launch();
    });
    after(async () => {
        await browser.close();
    });
    beforeEach(async () => {
        page = await browser.newPage();
    });
    afterEach(async () => {
        await page.close();
    });


    it("load and displays all books", async () => {
        // await (new Promise(resolve => setTimeout(resolve, 2000)));
        await page.route("**/jsonstore/collections/books*/", (route) => {
            route.fulfill(json(mockData));
        });
        await page.goto("http://localhost:5000");
        await page.click("text=Load All Books");
        await page.waitForSelector("text=Harry Potter");
        let rows = await page.$$eval("tr", (rows) => rows.map(r => r.textContent.trim()));
        expect(rows[1]).to.contains("Harry Potter");
        expect(rows[1]).to.contains("J.K.Rowling");
        expect(rows[2]).to.contains("C# Fundamentals");
        expect(rows[2]).to.contains("Svetlin Nakov");
    });

    it.only("can create book", async () => {
        await page.goto("http://localhost:5000");
        await page.fill("form#createForm >> input[name=title]", "Title");
        await page.fill("form#createForm >> input[name=author]", "Author");
        await page.click("form#createForm >> text=Submit");
        await page.waitForTimeout(60000);
    });



// dont work



});