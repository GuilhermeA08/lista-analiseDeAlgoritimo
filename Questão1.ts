// Implemente um programa (em qualquer linguagem)
// Que dada uma mochila de capacidade M e um conjunto de n itens
// (onde cada item possui um peso (w1, w2, ...,wn)
// e um valor (v1, v2, ..., vn)), seja capaz de exibir
// o subconjunto mais valioso de itens que caibam dentro da mochila.
// O seu programa deve basear-se na estratégia de força bruta.

// Lib de leitura de entrada pelo terminal
import * as readlineSync from "readline-sync";

// Interfaces ============================================================
interface Mochila {
  capacidadeTotal: number;
}

interface Item {
  nome: string;
  peso: number;
  valor: number;
}

// ========================================================================

// Variáveis ==============================================================
let valorDaMochila = 0;
const mochila: Mochila = { capacidadeTotal: 0 };

const itens: Item[] = [
  { nome: "Corda", peso: 1, valor: 7 },
  { nome: "Lanterna", peso: 2, valor: 5 },
  { nome: "Comida", peso: 3, valor: 15 },
  { nome: "Água", peso: 4, valor: 20 },
  { nome: "Faca", peso: 5, valor: 25 },
  { nome: "Bússola", peso: 6, valor: 14 },
  { nome: "Bastão", peso: 7, valor: 35 },
  { nome: "Lapis", peso: 8, valor: 22 },
  { nome: "Copo", peso: 9, valor: 45 },
  { nome: "Relógio", peso: 7, valor: 33 },
];
// ========================================================================

// Leitura da capacidade da mochila ========================================

mochila.capacidadeTotal = Number(readlineSync.question("Qual a capacidade da Mochila: "));

console.log("Capacidade da mochila: " + mochila.capacidadeTotal + " kg");

// ========================================================================

function getAllCombinations<T>(arr: T[]): T[][] {
  if (arr.length === 0) {
    return [[]];
  } else {
    const result: T[][] = [];
    const rest = getAllCombinations(arr.slice(1));
    for (let i = 0; i < rest.length; i++) {
      for (let j = 0; j <= rest[i].length; j++) {
        const copy = rest[i].slice();
        copy.splice(j, 0, arr[0]);
        result.push(copy);
      }
    }
    return result;
  }
}
async function melhorCombinacao() {
  const combinations = getAllCombinations<Item>(itens);

  //Checar os itens que cabem na mochila
  const itensQueCabemNaMochila = combinations.filter((mochilaTeste) => {
    let pesoTotal = 0;
    mochilaTeste.forEach((i) => {
      pesoTotal += i.peso;
    });
    return pesoTotal <= mochila.capacidadeTotal;
  });

  //Melhor combinação
  let melhorCombinacao: Item[] = [];
  let melhorValor = 0;

  itensQueCabemNaMochila.forEach((mochila) => {
    let valorTotal = 0;
    mochila.forEach((i) => {
      valorTotal += i.valor;
    });
    if (valorTotal > melhorValor) {
      melhorValor = valorTotal;
      melhorCombinacao = mochila;
    }
  });

  //Mostrar melhor combinação
  console.log("Melhor combinação: ");
  console.log("Valor: " + melhorValor);

  melhorCombinacao.forEach((i) => {
    console.log(i.nome);
  });
}

melhorCombinacao();
