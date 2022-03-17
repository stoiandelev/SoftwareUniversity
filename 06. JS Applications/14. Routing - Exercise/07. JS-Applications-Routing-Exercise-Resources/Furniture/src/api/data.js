import * as api from './api.js';

export let login = api.login;
export let register = api.register;
export let logout = api.logout;

let endpoint = {
    all: "/data/catalog",
    byId: "/data/catalog/",
    myItems: (userId) => `/data/catalog?where=_ownerId%3D%22${userId}%22`,
    create: "/data/catalog",
    edit: "/data/catalog/",
    delete: "/data/catalog/"
};

export async function getAll() {
    return api.get(endpoint.all);
};

export async function getById(id) {
    return api.get(endpoint.byId + id);
};

export async function getMyItems(userId) {
    return api.get(endpoint.myItems(userId));
};

export async function createItem(data) {
    return api.post(endpoint.create, data);
};

export async function editItem(id, data) {
    return api.put(endpoint.edit + id, data);
};

export async function deleteItem(id) {
    return api.del(endpoint.delete + id);
};




