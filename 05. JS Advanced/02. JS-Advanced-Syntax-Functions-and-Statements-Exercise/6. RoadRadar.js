function roadRadar(speed, area) {

    let motorway = 130;
    let interstate = 90;
    let city = 50;
    let residential = 20;

    let difference = 0;
    let speedZone = 0;
    let overLimit = "";

    switch (area) {
        case "motorway":
            speedZone = motorway;
            break;
        case "interstate":
            speedZone = interstate;
            break;
        case "city":
            speedZone = city;
            break;
        case "residential":
            speedZone = residential;
            break;
        default:
            console.log("Unknown Area")
    }

    if (speed > speedZone) {
        difference = speed - speedZone;

        if (difference > 0) {
            if (difference <= 20) {
                overLimit = "speeding";
            } else if (difference <= 40) {
                overLimit = "excessive speeding";
            } else {
                overLimit = "reckless driving";
            }
        }

        console.log(`The speed is ${difference} km/h faster than the allowed speed of ${speedZone} - ${overLimit}`)
    } else {
        console.log(`Driving ${speed} km/h in a ${speedZone} zone`)
    }
}

roadRadar(40, 'city')