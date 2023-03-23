package backtracking.question5;

import java.util.ArrayList;
import java.util.Scanner;

public class question5 {

  public static Scanner sc = new Scanner(System.in);

  private static final char[] ALPHABET = { 'N', 'O', 'P' };
  private static String firstSolution = null;

  public static void main(String[] args) {
    // Entradas
    ArrayList<Integer> entradas = new ArrayList<Integer>();

    int n = sc.nextInt();

    // Leitura das entradas
    while (n != 0) {
      entradas.add(n);
      n = sc.nextInt();
    }

    entradas.add(0);

    // Processamento
    for (int i = 0; i < entradas.size(); i++) {
      int index = entradas.get(i);
      generateThueMorse("", index);
      firstSolution = null;
    }
  }

  public static void generateThueMorse(String sequence, int n) {
    if (n == 0 && firstSolution == null) {
      firstSolution = sequence;
      System.out.println(sequence);
      return;
    }

    for (char c : ALPHABET) {
      if (!containsForbiddenSubsequence(sequence + c)) {
        generateThueMorse(sequence + c, n - 1);
      }
      if (firstSolution != null) {
        return;
      }
    }
  }

  public static boolean containsForbiddenSubsequence(String sequence) {
    String str = new String(sequence);
    int length = str.length();
    for (int i = 1; i <= length / 2; i++) {
      String first = str.substring(length - i - i, length - i);
      String second = str.substring(length - i, length);
      if (first.equals(second)) {
        return true;
      }
    }
    return false;
  }
}
