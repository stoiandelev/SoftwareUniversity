function attachEvents() {
    loadContacts();
    document.getElementById("btnLoad").addEventListener("click", loadContacts);
    document.getElementById("btnCreate").addEventListener("click", onCreate);
    listOfContacts.addEventListener("click", onDelete);
}

let listOfContacts = document.getElementById("phonebook");
let personInput = document.getElementById("person");
let phoneInput = document.getElementById("phone");

attachEvents();

async function onDelete(event) {
    let id = event.target.dataset.id;
    if (id !== undefined) {
       await deleteContact(id);
       event.target.parentElement.remove()
    }
}

async function onCreate() {
    let person = personInput.value;
    let phone = phoneInput.value;
    let contact = {person, phone}

    let result = await createContact(contact);
    listOfContacts.appendChild(createItem(result));

    personInput.value = "";
    phoneInput.value = "";
}

async function loadContacts() {
    let url = "http://localhost:3030/jsonstore/phonebook";
    let response = await fetch(url);
    let data = await response.json();

    listOfContacts.replaceChildren();
    Object.values(data).map(createItem).forEach(el => listOfContacts.appendChild(el));

}


function createItem(contact) {
    let liElement = document.createElement("li");
    liElement.innerHTML = `${contact.person}: ${contact.phone} <button data-id="${contact._id}">Delete</button>`;
    return liElement;
}

async function createContact(contact) {
    let url = "http://localhost:3030/jsonstore/phonebook";
    let option = {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(contact)
    }

    let response = await fetch(url, option);
    let result = await response.json();

    return result;
}

async function deleteContact(id) {
    let url = `http://localhost:3030/jsonstore/phonebook/${id}`;
    let option = {
        method: "delete"
    };
    let response = await fetch(url, option);
    let result = await response.json();
    return result;
}

