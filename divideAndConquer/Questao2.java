package divideAndConquer;

import java.util.Scanner;

public class Questao2 {

    public static int somaVetor(int[] numeros, int inicial, int ultimo) {
        if (inicial == ultimo) {
            return numeros[inicial];
        } else {
            int meio = (inicial + ultimo) / 2;
            int soma1 = somaVetor(numeros, inicial, meio);
            int soma2 = somaVetor(numeros, meio + 1, ultimo);
            return soma1 + soma2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeros[i] = sc.nextInt();
        }
        sc.close();

        int soma = somaVetor(numeros, 0, n - 1);
        System.out.println("Soma = " + soma);
    }
}
