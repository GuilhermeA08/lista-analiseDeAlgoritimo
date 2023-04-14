package dynamicProgamming;

import java.util.Scanner;

public class Questao4 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int numTamCanos = sc.nextInt();
        int tamCano = sc.nextInt();

        int matrizCanos[][] = new int[numTamCanos + 1][tamCano + 1];

        for(int i = 1; i <= numTamCanos; i++) {
            
            int comp = sc.nextInt();
            int valor = sc.nextInt();
            
            for(int j = 1; j <= tamCano; j++) {

                // Implementação da fórmula de recorrência
                if (comp > j) {
                    matrizCanos[i][j] = matrizCanos[i-1][j]; // não é possível cortar o cano
                } else {
                    // primeira opção: não corta o cano e mantém o valor máximo
                    // segunda opção: corta o cano de comprimento i de um cano de comprimento j
                    matrizCanos[i][j] = Math.max(matrizCanos[i-1][j], matrizCanos[i][j-comp] + valor);
                }
            }
        }

        // Valor máximo
        System.out.println(matrizCanos[numTamCanos][tamCano]);

        sc.close();

    }
    
}
