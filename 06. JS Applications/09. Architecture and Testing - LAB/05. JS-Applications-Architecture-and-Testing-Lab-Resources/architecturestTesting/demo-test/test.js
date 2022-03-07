// const { chromium } = require('playwright-chromium');
// (async () => {
//   const browser = await chromium.launch();
//   const page = await browser.newPage();
//   await page.goto('https://google.com/');
//   await page.screenshot({ path: `example.png` });
//   await browser.close();
// })();

const { chromium, firefox } = require('playwright-chromium');
const { expect } = require('chai');

let browser, page; // Declare reusable variables

describe('E2E tests', async function () {
  this.timeout(60000);
  //{ headless: false, slowMo: 2000 }
  before(async () => { browser = await firefox.launch( { headless: false, slowMo: 2000 } ); });
  after(async () => { await browser.close(); });
  beforeEach(async () => { page = await browser.newPage(); });
  afterEach(async () => { await page.close(); });


  it('check page title', async () => {
    //nav to page
    await page.goto('http://192.168.0.131:5000/01.%20Accordion/index.html');
    // form wait the data it error!
    await page.waitForSelector('.accordion');
    //check title.textContent
    let content = await page.textContent("#main");

    expect(content).to.contains("Scalable Vector Graphics");
    expect(content).to.contains("Open standard");
    expect(content).to.contains("Unix");
    expect(content).to.contains("ALGOL");
  });

  it("More button works", async () => {
    await page.goto('http://192.168.0.131:5000/01.%20Accordion/index.html');
    await page.waitForSelector('.accordion');

    //click on the first match
    await page.click("text=More");

    await page.waitForResponse(/articles\/details/i);

    // await page.waitForSelector('.accordion p');
    let visible = await page.isVisible(".accordion p");
    expect(visible).to.be.true;

  });

  it("Less button works", async () => {
    await page.goto('http://192.168.0.131:5000/01.%20Accordion/index.html');
    await page.waitForSelector('.accordion');
    
    await page.click("text=More");
    await page.waitForResponse(/articles\/details/i);
    await page.waitForSelector(".accordion p", { state: "visible" });

    await page.click("text=Less");
    let visible = await page.isVisible(".accordion p");
    expect(visible).to.be.false;

  });

  it.only("form-input", async () => {
    await page.goto('http://192.168.0.131:5000/01.%20Accordion/index.html');

    await page.fill("[name=email]", "Stoyan");
    await page.waitForTimeout(60000);


  })

});
