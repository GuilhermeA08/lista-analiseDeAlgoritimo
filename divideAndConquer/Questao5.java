package divideAndConquer;

import java.util.Scanner;

public class Questao5 {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int tamanhoBaralho = sc.nextInt();
    int repeticoes = 0;

    int cartas[] = new int[tamanhoBaralho];

    for (int i = 0; i < cartas.length; i++) {
      cartas[i] = i;
    }

    cartas = embaralhar(cartas);

    while (!isOrdenado(cartas)) {
      cartas = embaralhar(cartas);
      repeticoes++;
    }

    System.out.println(repeticoes);
  }

  public static int[] embaralhar(int[] cartas) {
    int[] cartasEmbaralhadas = new int[cartas.length];
    int metade = cartas.length / 2;

    for (int i = 0; i < metade; i++) {
      cartasEmbaralhadas[i * 2] = cartas[i];
      cartasEmbaralhadas[i * 2 + 1] = cartas[i + metade];
    }

    return cartasEmbaralhadas;
  }

  public static boolean isOrdenado(int[] cartas) {
    for (int i = 0; i < cartas.length - 1; i++) {
      if (cartas[i] > cartas[i + 1]) {
        return false;
      }
    }
    return true;
  }
}
