package divideAndConquer;

import java.util.Scanner;

public class Questao6 {

    static int numeroTrocas;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int numeroTestes = sc.nextInt();

        for (int i = 0; i < numeroTestes; i++) {
            int tamanhoTrem = sc.nextInt();
            int[] ordemVagoes = new int[tamanhoTrem];
            numeroTrocas = 0;

            for(int j = 0; j < tamanhoTrem; j++) {
                ordemVagoes[j] = sc.nextInt();
            }

            mergeSort(ordemVagoes, 0, tamanhoTrem - 1);

            System.out.println("Optimal train swapping takes " + numeroTrocas + " swaps");

        }

        sc.close();
    }

    
    public static void mergeSort(int[] ordemVagoes, int primeiro, int ultimo) {

        if (primeiro >= ultimo) {
            return;
        } else {
            int meio = (primeiro + ultimo) / 2;
            mergeSort(ordemVagoes, primeiro, meio);
            mergeSort(ordemVagoes, meio + 1, ultimo);
            merge(ordemVagoes, primeiro, meio, ultimo);
        }
        
    }

    public static void merge(int[] ordemVagoes, int primeiro, int meio, int ultimo) {
        
        int[] auxiliar = new int[ordemVagoes.length];

        for(int i = primeiro; i <= ultimo; i++) {
            auxiliar[i] = ordemVagoes[i];
        }

        int i = primeiro; // índice que marca o início do primeiro vetor
        int j = meio + 1; // índice que marca o início do segundo vetor
        int k = primeiro; // índice que marca a posição do menor valor depois da comparação

        // Processo de comparação dos índices de cada vetor
        while (i <= meio && j <= ultimo) {
            if (auxiliar[i] > auxiliar[j]) {
                ordemVagoes[k++] = auxiliar[j++];
                numeroTrocas += (meio - i + 1);
                
            } else {
                ordemVagoes[k++] = auxiliar[i++];
            }
        }

        while (i <= meio) {
            ordemVagoes[k++] = auxiliar[i++];
        }

        while (j <= ultimo) {
            ordemVagoes[k++] = auxiliar[j++];
        }

    }
    
}
