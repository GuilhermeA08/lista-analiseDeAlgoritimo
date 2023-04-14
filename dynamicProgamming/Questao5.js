function findMaxTriangleHeight(columnHeights) {
  const n = columnHeights.length; 
  let maxHeight = 0;

  for (let i = 0; i < n; i++) {
      const triangleHeight = Math.min(...columnHeights) - i;
      if (triangleHeight > maxHeight) {
          maxHeight = triangleHeight;
      }
      const minIndex = columnHeights.indexOf(Math.min(...columnHeights));
      columnHeights[minIndex] -= 1;
  }

  return maxHeight;
}

 var columnHeights = "10 5 20 10 5 7 7 5".split(" ")
  .map(height => parseInt(height));
  
const maxTriangleHeight = findMaxTriangleHeight(columnHeights);
console.log(maxTriangleHeight);
