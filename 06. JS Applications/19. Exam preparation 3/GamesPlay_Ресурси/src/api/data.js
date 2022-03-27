import * as api from './api-crud.js';

export let login = api.login;
export let register = api.register;
export let logout = api.logout;

const endpoint = {
    allGame: '/data/games?sortBy=_createdOn%20desc',
    homePage: "/data/games?sortBy=_createdOn%20desc&distinct=category",
    gameById: "/data/games/",
    createGame: "/data/games",
    editGame: "/data/games/",
    deleteGame: "/data/games/"
    // myBooks: (userId) => `/data/books?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`
    
};

export async function getAllGames() {
    return api.get(endpoint.allGame);
};

export async function getHomePage() {
    return api.get(endpoint.homePage);
};

export async function getGameById(id) {
    return api.get(endpoint.gameById + id);
};

export async function createGame(game) {
    return api.post(endpoint.createGame, game);
};

export async function editGame(id, game) {
    return api.put(endpoint.editGame + id, game);
};

export async function deleteGame(id) {
    return api.del(endpoint.deleteGame + id);
};

// export async function getMyBooks(userId) {
//     return api.get(endpoint.myBooks(userId));
// };








