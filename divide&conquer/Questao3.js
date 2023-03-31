
// subcadeia de soma máxima
var vetor = [6, -2, 11, -4, 13, -5, -2];
var soma = 0;
var maiorSoma = 0;
var inicio = 0;
var fim = 0;

function SomaMaxima(vetor, i, j) {
  if (i == j) {
    if (vetor[i] > 0) {
      soma = vetor[i];
    } else {
      soma = 0;
    }
  } else {
    var meio = Math.floor((i + j) / 2);
    SomaMaxima(vetor, i, meio);
    var somaEsquerda = soma;
    SomaMaxima(vetor, meio + 1, j);
    var somaDireita = soma;
    var somaMeio = 0;
    var somaTemp = 0;
    for (var k = meio; k >= i; k--) {
      somaTemp = somaTemp + vetor[k];
      if (somaTemp > somaMeio) {
        somaMeio = somaTemp;
				inicio = k;
      }
    }
    somaTemp = somaMeio;
    for (var k = meio + 1; k <= j; k++) {
      somaTemp = somaTemp + vetor[k];
      if (somaTemp > somaMeio) {
        somaMeio = somaTemp;
				fim = k;
      }
    }
    soma = Math.max(somaEsquerda, somaDireita, somaMeio);
  }
}

SomaMaxima(vetor, 1, vetor.length - 1);
console.log("i = ",inicio,"j = ", fim,"SomaMáxima = ",soma);