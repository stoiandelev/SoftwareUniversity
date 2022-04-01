import * as api from './api.js';    


export let login = api.login;
export let register = api.register;
export let logout = api.logout;

let endpoints = {
    movies: "/data/movies"
};

export async function getAllMovies() {
    return api.get(endpoints.movies);
}