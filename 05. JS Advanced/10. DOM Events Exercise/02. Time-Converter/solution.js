function attachEventsListeners() {

    let ration = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    };

    function convert(value, unit) {
        let inDays = value / ration[unit];
        return {
            days: inDays,
            hours: inDays * ration.hours,
            minutes: inDays * ration.minutes,
            seconds: inDays * ration.seconds
        }
    }

    //глобална функция за да може да я тестваме в браузера
    window.convert = convert;

    //eventListener върху отделните input

    let daysInput = document.getElementById("days");
    let hoursInput = document.getElementById("hours");
    let minutesInput = document.getElementById("minutes");
    let secondsInput = document.getElementById("seconds");

    document.getElementById("daysBtn").addEventListener("click", onConvert);
    document.getElementById("hoursBtn").addEventListener("click", onConvert);
    document.getElementById("minutesBtn").addEventListener("click", onConvert);
    document.getElementById("secondsBtn").addEventListener("click", onConvert);

    function onConvert(e) {
        let input = e.target.parentElement.querySelector("input[type = 'text']");
        let time = convert(Number(input.value), input.id);
        daysInput.value = time.days;
        hoursInput.value = time.hours;
        minutesInput.value = time.minutes;
        secondsInput.value = time.seconds;
    }

}