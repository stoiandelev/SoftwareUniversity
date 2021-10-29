function solve() {
    const text = document.getElementById("text").value;
    const namingConvention = document.getElementById("naming-convention").value;
    const resultContainer = document.getElementById("result");

    //получаваме всяка отделна дума
    let spited = text.split(" ");

    let resultString = "";
    if (namingConvention === "Pascal Case") {
        for (let i = 0; i < spited.length; i++) {
            resultString += spited[i][0].toUpperCase() + spited[i].slice(1, spited[i].length).toLowerCase();
        }
    } else if (namingConvention === "Camel Case") {
        resultString += spited[0][0].toLowerCase() + spited[0].slice(1, spited[0].length).toLowerCase();
        for (let i = 1; i < spited.length; i++) {
            resultString += spited[i][0].toUpperCase() + spited[i].slice(1, spited[i].length).toLowerCase();
        }
    } else {
        resultContainer.innerHTML = "Error!"
        return;
    }
    resultContainer.innerHTML = resultString;
}