function findMaxTriangleHeight(columnHeights) {
  const n = columnHeights.length; // número de colunas
  let maxHeight = 0; // inicializa altura máxima como 0

  for (let i = 0; i < n; i++) {
      // Calcula a altura do triângulo formado ao remover os cubos de cima para baixo em colunas
      // A altura do triângulo será a altura mínima entre as colunas subtraída do índice (i)
      const minIndex = columnHeights.indexOf(Math.min(...columnHeights));
      const triangleHeight = Math.min(...columnHeights) - i;

      // Atualiza a altura máxima se a altura do triângulo atual for maior
      if (triangleHeight > maxHeight) {
          maxHeight = triangleHeight;
      }

      // Remove o cubo do topo da coluna com altura mínima
      columnHeights[minIndex] -= 1;
  }

  return maxHeight;
}

// Leitura de entrada
const input = "5 1 1 1 1 1 1 3";
const inputArray = input.split(" ");
const n = parseInt(inputArray[0]); // número de colunas na parede
const columnHeights = inputArray.slice(1).map(height => parseInt(height)); // alturas de cada coluna como um array

// Chama a função e imprime o resultado
const maxTriangleHeight = findMaxTriangleHeight(columnHeights);
console.log(maxTriangleHeight);
