function swap(input: any) {
    for(var i = 0; i < input[0]; i++) {
        var array = input[1];
        var count = 0;
        var aux = array[i][1];
        for (let index = 0; index < aux.length; index++) {
            if (aux[index] > aux[index + 1]) {
                var temp = aux[index];
                aux[index] = aux[index + 1];
                aux[index + 1] = temp;
                count++;
                index = -1;
            }
        }
        console.log("Optimal train swapping takes "+count+" swaps.");
    }
}

swap([3, [[3, [1, 3, 2]], [5, [4,3,5, 2, 1]], [2, [2, 1]]]]);