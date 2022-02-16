window.addEventListener('load', solution);

function solution() {
    let fullNameField = document.querySelector("#fname");
    let emailField = document.querySelector("#email");
    let phoneNumberField = document.querySelector('#phone');
    let addressField = document.querySelector('#address');
    let postalCodeField = document.querySelector('#code');
    const submitBtn = document.querySelector('#submitBTN');
    const editBtn = document.querySelector('#editBTN');
    const continueBtn = document.querySelector('#continueBTN');

    submitBtn.addEventListener('click', submitHandler);

    function submitHandler(event) {
        event.preventDefault();
        const fullName = fullNameField.value;
        const email = emailField.value;
        const phone = phoneNumberField.value;
        const address = addressField.value;
        const postalCode = postalCodeField.value;

        if (fullName === '' && email === '') {
            return;
        }

        let ul = document.querySelector('#infoPreview');

        ul.appendChild(e('li', {}, `Full Name: ${fullName}`));
        ul.appendChild(e('li', {}, `Email: ${email}`));
        ul.appendChild(e('li', {}, `Phone Number: ${phone}`));
        ul.appendChild(e('li', {}, `Address: ${address}`));
        ul.appendChild(e('li', {}, `Postal Code: ${postalCode}`));


        fullNameField.value = '';
        emailField.value = '';
        phoneNumberField.value = '';
        addressField.value = '';
        postalCodeField.value = '';

        submitBtn.disabled = true;
        editBtn.disabled = false;
        continueBtn.disabled = false;

        editBtn.addEventListener('click', () => {
            fullNameField.value = fullName;
            emailField.value = email;
            phoneNumberField.value = phone;
            addressField.value = address;
            postalCodeField.value = postalCode;

            submitBtn.disabled = false;
            editBtn.disabled = true;
            continueBtn.disabled = true;

            // ul.remove();
            // document.querySelector('.preview').appendChild(e('ul', { id: 'infoPreview' }));
            let inputs = Array.from(event.target.parentElement.parentElement.querySelectorAll('li'));
            inputs.forEach(el => el.remove());

        });
        continueBtn.addEventListener('click', () => {
            const parent = document.getElementById("block");
            while (parent.firstChild) {
                parent.firstChild.remove();
            }
            parent.appendChild(e('h3', {}, 'Thank you for your reservation!'));
        });
    }



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
}
