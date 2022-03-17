import * as api from "../api/api.js";

export let login = api.login;
export let register = api.register;
export let logout = api.logout;

let endpoints = {
    allMovies: "/data/movies",
    movieById: "/data/movies/"
};

export async function getAllMovies() {
    return api.get(endpoints.allMovies);
};

export async function getMovieById(id) {
    return api.get(endpoints.movieById + id);
};






