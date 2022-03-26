import * as api from './api-crud.js';

export let login = api.login;
export let register = api.register;
export let logout = api.logout;

let endpoint = {
    allMemes: "/data/memes?sortBy=_createdOn%20desc",
    memesById: "/data/memes/",
    myItems: (userId) => `/data/memes?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`,
    createMeme: "/data/memes",
    editMeme: "/data/memes/",
    deleteMeme: "/data/memes/"
};

export async function getAllMemes() {
    return api.get(endpoint.allMemes);
};

export async function getMemeById(id) {
    return api.get(endpoint.memesById + id);
};

export async function getMyMemes(userId) {
    return api.get(endpoint.myItems(userId));
};

export async function createMeme(meme) {
    return api.post(endpoint.createMeme, meme);
};

export async function editMeme(id, meme) {
    return api.put(endpoint.editMeme + id, meme);
};

export async function deleteMeme(id) {
    return api.del(endpoint.deleteMeme + id);
};




