package backtracking.question5;

import java.util.Scanner;

public class question5 {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int entrada = sc.nextInt();

    genetic(entrada);
    // while (entrada != 0) {}
  }

  public static void genetic(int entrada) {
    char[] vetor = new char[entrada];
    backtracking(entrada - 1, vetor);

    for (int i = 0; i < entrada; i++) {
      System.out.print(vetor[i]);
    }
    System.out.println();
  }

  public static void backtracking(int entrada, char[] vetor) {
    if (entrada < 0) {
      return;
    }
    backtracking(entrada - 1, vetor);

    if (entrada == 0) {
      vetor[entrada] = 'N';
    } else {
      vetor[entrada] = 'O';
    }
  }
}
