function attachEvents() {

    document.getElementById("refresh").addEventListener("click", loadMessages);
    document.getElementById("submit").addEventListener("click", onSubmit);

    // за да зареди всички съобщения още в началото
    loadMessages();
}

attachEvents();

let authorInput = document.querySelector("[name=author]");
let contentInput = document.querySelector("[name=content]");
let listOfMessages = document.getElementById("messages");

async function onSubmit() {
    let author = authorInput.value;
    let content = contentInput.value;
    let result = await createMessage({author, content});
    contentInput.value = "";

    //добавяме ги в листа със съобщенията
    listOfMessages.value += "\n" + `${author}: ${content}`;
}

async function loadMessages() {
    let url = "http://localhost:3030/jsonstore/messenger";
    let resp = await fetch(url);
    let data = await resp.json();

    let messages = Object.values(data);

    listOfMessages.value = messages.map(m => `${m.author}: ${m.content}`).join("\n");
}

async function createMessage(message) {
    let url = "http://localhost:3030/jsonstore/messenger";
    let option = {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(message)

    }
    let response = await fetch(url, option);
    let result = response.json();
    return result;
}





