function sortAnArrayBy2Criteria(arr) {
    const result = arr.sort((a, b) => {
            // по дължина
        if (a.length > b.length) {
            return 1;
            //  ascending order
        } else if (a.length === b.length) {
            return a.localeCompare(b);
        } else {
            return -1;
        }
    })
    console.log(result.join("\n"));
}

sortAnArrayBy2Criteria(['alpha',
    'beta',
    'gamma']
)