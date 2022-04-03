import { clearUserData, getUserData, setUserData } from "../util.js";
import { notify } from "../common/notification.js";

let host = "http://localhost:3030";

async function request(url, options) {
    try {
        let response = await fetch(host + url, options);
        if (response.ok != true) {
            if (response.status == 403) {
                clearUserData();
            };

            let error = await response.json();
            throw new Error(error.message);
        };
        if (response.status == 204) {
            return response;
        } else {
            let data = response.json();
            return data;
        }

    } catch (err) {
        // alert(err.message);
        notify(err.message);
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
        email: response.email,
        id: response._id,
        token: response.accessToken
    };
    setUserData(userData);
};

export async function register(email, password) {
    let response = await request("/users/register", createOptions("POST", { email, password }));
    let userData = {
        email: response.email,
        id: response._id,
        token: response.accessToken
    };
    setUserData(userData);
};

export async function logout() {
    await request("/users/logout", createOptions());
    clearUserData();
}