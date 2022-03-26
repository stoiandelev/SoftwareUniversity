import { notify } from "../notify.js";
import { clearUserData, getUserData, setUserData } from "./util.js";

let host = "http://localhost:3030";

async function request(url, options) {
    try {
        const response = await fetch(host + url, options);

        if (response.ok == false) {
            const error = await response.json();
            throw new Error(error.message);
        };

        try {
            return await response.json();
        } catch (err) {
            return response;
        };

    } catch (err) {
        // alert(err.message);
        notify(err.message)
        throw err;
    }
};

function createOptions(method = "GET", data) {
    let options = {
        method,
        headers: {}
    };

    if (data != undefined) {
        options.headers["Content-Type"] = "application/json";
        options.body = JSON.stringify(data);
    };

    let userData = getUserData();
    if (userData != null) {
        options.headers["X-Authorization"] = userData.token;
    };

    return options;
}

export async function get(url) {
    return request(url, createOptions());
};

export async function post(url, data) {
    return request(url, createOptions("POST", data));
};

export async function put(url, data) {
    return request(url, createOptions("PUT", data));
};

export async function del(url) {
    return request(url, createOptions("DELETE"));
};


export async function login(email, password) {
    let response = await request("/users/login", createOptions("POST", { email, password }));
    let userData = {
        username: response.username,
        email: response.email,
        id: response._id,
        gender: response.gender,
        token: response.accessToken
    };
    setUserData(userData);
};

export async function register(username, email, password, gender) {
    let response = await request("/users/register", createOptions("POST", { username, email, password, gender }));
    let userData = {
        username: response.username,
        email: response.email,
        id: response._id,
        gender: response.gender,
        token: response.accessToken
    };
    setUserData(userData);

};

export async function logout() {
    request("/users/logout", createOptions());
    clearUserData();
}