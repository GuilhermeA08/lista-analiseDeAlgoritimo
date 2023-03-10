function swap(num: number, array: any) {
    for (let i = 0; i < num; i++) {
        var count = 0;
        var aux = array[i];
        for (let index = 0; index < aux[0]; index++) {
            if (aux[1][index] > aux[1][index + 1]) {
                var temp = aux[1][index];
                aux[1][index] = aux[1][index + 1];
                aux[1][index + 1] = temp;
                count++;
                index = -1;
            }
        }
        console.log("Optimal train swapping takes "+count+" swaps.");
    }
}

swap(2, [[3, [1, 3, 2]], [4, [4, 3, 2, 1]]]);