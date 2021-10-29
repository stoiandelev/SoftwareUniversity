function lockedProfile() {
    // в елементите който отговарят на profile ми дай button
    Array.from(document.querySelectorAll(".profile button"))
        .forEach(b => b.addEventListener("click", onToggle));

    function onToggle(e) {
        // let infoDiv = Array
        //     .from(e.target.parentElement.querySelectorAll("div"))
        //     .find(d => d.id.includes("HiddenFields"));

        let profile = e.target.parentElement;
        let isActive = profile.querySelector("input[type = radio][value = 'unlock']").checked;

        if (isActive) {
            let infoDiv = profile.querySelector("div");
            if (e.target.textContent === "Show more") {
                infoDiv.style.display = "block";
                e.target.textContent = "Hide it";
            } else {
                infoDiv.style.display = "";
                e.target.textContent = "Show more";
            }
        }
    }
}