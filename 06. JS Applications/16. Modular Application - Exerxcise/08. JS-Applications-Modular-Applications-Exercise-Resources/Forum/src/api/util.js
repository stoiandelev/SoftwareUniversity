
export function getUserData() {
    return JSON.parse(sessionStorage.getItem("userData"));
};

export function setUserData(data) {
    sessionStorage.setItem("userData", JSON.stringify(data));
};

export function clearUserData() {
    sessionStorage.removeItem("userData");
};

export function createSubmitHeader(callback, ...fieldNames) {
    return function (event) {
        event.preventDefault();
        let formData = new FormData(event.target);

        let result = {};

        for(let field of fieldNames) {
            result[field] = formData.get(field).trim();
        };

        callback(result, event);

    };
};
