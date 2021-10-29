function solve() {
    let text = document.getElementById("input").value;
    let spitedText = text.split(".").filter((el) => el !== "");
    let output = document.getElementById("output");

    for (let i = 0; i < spitedText.length; i += 3) {
        let arr = [];
        for (let y = 0; y < 3; y++) {
            if (spitedText[i + y]) {
                arr.push(spitedText[i + y]);
            }
        }
        let paragraph = arr.join(". ") + ".";
        output.innerHTML += `<p>${paragraph}</p>>`;
    }


}