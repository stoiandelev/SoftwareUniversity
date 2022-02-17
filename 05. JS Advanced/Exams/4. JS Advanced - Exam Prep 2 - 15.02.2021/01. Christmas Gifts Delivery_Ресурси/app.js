function solution() {

    //чрез деструктириране взимаме трите елемента
    const[gifts, sent, discarded] = document.querySelectorAll('section ul');
    const input = document.querySelector('input');

    document.querySelector('button').addEventListener('click', addGift);

    function addGift() {
        let name = input.value;
        input.value = '';

        const li = e('li', name, 'gift');
        const sendButton = e('button', 'Send', 'sendButton');
        const discardButton = e('button', 'Discard', 'discardButton')

        gifts.appendChild(li);
        li.appendChild(sendButton);
        li.appendChild(discardButton);

        Array.from(gifts.children)
            .sort((a,b) => a.textContent
            .localeCompare(b.textContent))
            .forEach(g => gifts.appendChild(g));

        sendButton.addEventListener('click', sentGift);
        discardButton.addEventListener('click', discardedGifts);
    }
    function sentGift(event) {
        let giftName = event.target.parentNode.childNodes[0].textContent;
        let element = event.target.parentNode;
        element.remove();

        let li = e('li', giftName, 'gift');
        sent.appendChild(li);
    }

    function discardedGifts(event){
        let giftName = event.target.parentNode.childNodes[0].textContent;
        let element = event.target.parentNode;
        element.remove();

        let li = e('li', giftName, 'gift');
        discarded.appendChild(li);
    }






    function e(type, content, className){
        const result = document.createElement(type);
        result.textContent = content;
        if (className) {
            result.className = className;
        }
        return result;
    }


    // function e(type, attributes, ...content) {
    //     const result = document.createElement(type);
    //
    //     for (let [attr, value] of Object.entries(attributes || {})) {
    //         if (attr.substring(0, 2) === 'on') {
    //             result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
    //         } else {
    //             result[attr] = value;
    //         }
    //     }
    //
    //     content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);
    //
    //     content.forEach(e => {
    //         if (typeof e == 'string' || typeof e == 'number') {
    //             const node = document.createTextNode(e);
    //             result.appendChild(node);
    //         } else {
    //             result.appendChild(e);
    //         }
    //     });
    //
    //     return result;
    // }
}