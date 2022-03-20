let element = document.querySelector("main");

export function showSection(section) {
    main.replaceChildren(section);
};




//TODO: first function to create html element
function e(type, attributes, ...content) {
    const result = document.createElement(type);
    for (let [attr, value] of Object.entries(attributes || {})) {
        if (attr.substring(0, 2) === 'on') {
            result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
        } else {
            result[attr] = value;
        }
    }
    content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);
    content.forEach(e => {
        if (typeof e == 'string' || typeof e == 'number') {
            const node = document.createTextNode(e);
            result.appendChild(node);
        } else {
            result.appendChild(e);
        }
    });

    return result;
}


//TODO: second function to create html element
function ev(type, content, className){
    const result = document.createElement(type);
    result.textContent = content;
    if (className) {
        result.className = className;
    }
    return result;
}