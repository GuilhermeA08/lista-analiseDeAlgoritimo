/*
    Análise de Algoritmos - Lista de Exercícios I - Unidade II 
    Questão 4 - Problema 1709 do Beecrowd - Baralho Embaralhado
*/

import * as readline from 'readline';

let numeroCartas: number = 0;
let baralho: number[] = [];
let numeroRepeticoes: number = 0;

//Declaração do módulo de leitura
var leitor = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

leitor.question("Qual o número de cartas do baralho?\n", function(answer) {
    numeroCartas = parseInt(answer);

    //Verifica se é um número par
    if (!isNaN(numeroCartas) && (numeroCartas % 2 === 0)) {

        // Preenche o vetor baralho com o número de cartas informado
        for (let i = 1; i <= numeroCartas; i++) {
            baralho.push(i);
        }

        // Realiza o emabaralhamento até que o baralho volte a ficar ordenado
        do {
            baralho = embaralhar(baralho);

            numeroRepeticoes++;

        } while (!ordenar(baralho));

        console.log(numeroRepeticoes);
    }

    leitor.close();
});

function embaralhar(baralho: number[]): number[] {

    let metadeBaralho: number = numeroCartas / 2;
    let baralhoIntercalado: number[] = [];

    for (let n = 0; n < metadeBaralho; n++) {
        baralhoIntercalado.push(baralho[metadeBaralho + n], baralho[n]);
    }

    return baralhoIntercalado;

};

function ordenar(baralho: number[]): boolean {

    for (let i = 0; i < baralho.length; i++) {
        if (baralho[i] > baralho[i + 1]) {
            return false;
        }
    }

    return true;
}