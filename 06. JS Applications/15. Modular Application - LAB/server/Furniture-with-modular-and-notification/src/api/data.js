import * as api from './api.js';

export let login = api.login;
export let register = api.register;
export let logout = api.logout;

let endpoint = {
    all: "/data/catalog?pageSize=4&offset=",
    count: "/data/catalog?count",
    byId: "/data/catalog/",
    myItems: (userId) => `/data/catalog?where=_ownerId%3D%22${userId}%22`,
    countMyItems: (userId) => `/data/catalog?where=_ownerId%3D%22${userId}%22&count`,
    create: "/data/catalog",
    edit: "/data/catalog/",
    delete: "/data/catalog/"
};

let pageSize = 4;

export async function getAll(page, search) {
    let url1 = endpoint.all + (page - 1) * pageSize;
    let url2 = endpoint.count

    if (search) {
        url1 += "&where=" + encodeURIComponent(` make LIKE "${search}"`);
        url2 += "&where=" + encodeURIComponent(` make LIKE "${search}"`);
    };


    let [data, count] = await Promise.all([
        api.get(url1),
        api.get(url2)
    ]);
    return {
        data,
        pages: Math.ceil(count / pageSize)
    };
};

export async function getById(id) {
    return api.get(endpoint.byId + id);
};

export async function getMyItems(userId) {
    let [data, count] = await Promise.all([
        api.get(endpoint.myItems(userId)),
        api.get(endpoint.countMyItems(userId))
    ]);
    return  {
        data,
        pages: Math.ceil(count / pageSize)
    };
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




