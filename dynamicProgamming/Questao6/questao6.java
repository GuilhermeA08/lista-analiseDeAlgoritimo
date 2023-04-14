package dynamicProgamming.Questao6;

import java.util.Scanner;

public class questao6 {

  static final int MOD = 1000000007; // valor do módulo

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int tempo = sc.nextInt(); // duração do exercício em minutos
    int minimo = sc.nextInt(); // valor mínimo de dificuldade permitido
    int maximo = sc.nextInt(); // valor máximo de dificuldade permitido

    int[][] dp = new int[tempo + 1][maximo + 2]; // tabela de programação dinâmica

    for (int i = minimo; i <= maximo; i++) {
      dp[1][i] = 1; // preenche a primeira linha da tabela
    }

    for (int i = 2; i <= tempo; i++) {
      for (int j = minimo; j <= maximo; j++) {
        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD; // soma as soluções dos subproblemas
      }
    }

    int count = 0;
    for (int i = minimo; i <= maximo; i++) {
      count = (count + dp[tempo][i]) % MOD; // combina as soluções dos subproblemas para obter a solução final
    }

    System.out.println(count);

    sc.close();
  }
}
