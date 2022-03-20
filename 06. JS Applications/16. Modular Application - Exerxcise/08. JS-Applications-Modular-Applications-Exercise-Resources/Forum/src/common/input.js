import { html, classMap } from "../library.js";

export let input = (label, type, name, value = "", hasError) => {
    if (type == "textarea") {

        return html`
            <label class=${classMap({ error: hasError })}><span>${label}</span><textarea name=${name} .value=${value}></textarea></label>`;


    } else {
        return html`
        <label class=${classMap({ error: hasError })}>
        <span>${label}</span><input type=${type} name=${name} value=${value} /></label>`;
    }
}