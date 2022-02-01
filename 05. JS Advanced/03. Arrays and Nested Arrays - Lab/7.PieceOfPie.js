function pieceOfPie(arr, startIndex, endIndex) {
    const firstIndex = arr.indexOf(startIndex);
    const lastIndex = arr.indexOf(endIndex);

    const result = arr.slice(firstIndex, lastIndex + 1)
    return result;
}

pieceOfPie(['Apple Crisp',
        'Mississippi Mud Pie',
        'Pot Pie',
        'Steak and Cheese Pie',
        'Butter Chicken Pie',
        'Smoked Fish Pie'],
    'Pot Pie',
    'Smoked Fish Pie'
)