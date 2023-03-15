package greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question5 {

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int numeroDeSoldados = 0;

    int numeroDeVitoriasDeNoglonia = 0;

    // ArrayList para armazenar os soldados
    ArrayList<Integer> soldadosQuadradônia = new ArrayList<Integer>();
    ArrayList<Integer> soldadosNoglônia = new ArrayList<Integer>();

    // Lê o número de soldados
    numeroDeSoldados = scanner.nextInt();

    // Lê os soldados da Quadradônia
    for (int i = 0; i < numeroDeSoldados; i++) {
      soldadosQuadradônia.add(scanner.nextInt());
    }

    // Lê os soldados da Noglônia
    for (int i = 0; i < numeroDeSoldados; i++) {
      int novoSoldado = scanner.nextInt();
      int posicaoDeInsercao = Collections.binarySearch(
        soldadosNoglônia,
        novoSoldado
      );
      if (posicaoDeInsercao < 0) {
        posicaoDeInsercao = -(posicaoDeInsercao + 1);
      }

      soldadosNoglônia.add(posicaoDeInsercao, novoSoldado);
    }

    // Percorre os soldados da Quadradônia
    for (int i = 0; i < numeroDeSoldados; i++) {
      // Verifica se o soldado da Noglônia é maior que o da Quadradônia
      for (int j = 0; j < numeroDeSoldados; j++) {
        if (soldadosNoglônia.get(j) > soldadosQuadradônia.get(i)) {
          // Se for, incrementa o número de vitórias da Noglônia
          numeroDeVitoriasDeNoglonia++;
          // Remove o soldado da Noglônia
          soldadosNoglônia.remove(j);
          // Sai do laço
          break;
        }
      }
    }

    System.out.println(numeroDeVitoriasDeNoglonia);
  }
}
