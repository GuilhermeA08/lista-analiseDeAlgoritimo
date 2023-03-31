import java.util.Scanner;

public class Questao4 {
    static int numeroJogadas;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // Quantidade de números da sequência
        
        while (n != 0) {
            int[] sequenciaNumeros = new int[n];
            numeroJogadas = 0;

            for (int i = 0; i < n; i++) {
                sequenciaNumeros[i] = sc.nextInt();
            }

            // Na primeira chamada, o primeiro índice é 0 e o último é n - 1
            mergeSort(sequenciaNumeros, 0, n - 1);

            if (numeroJogadas % 2 != 0) {
                System.out.println("Marcelo");
            } else {
                System.out.println("Carlos");
            }

            n = sc.nextInt();
        }

        sc.close();
    }

    public static void mergeSort(int[] sequencia, int primeiro, int ultimo) {

        if (primeiro >= ultimo) {
            return;
        } else {
            // Divide pela metade a sequência recebida
            int meio = (primeiro + ultimo) / 2;

            mergeSort(sequencia, primeiro, meio);

            mergeSort(sequencia, meio + 1, ultimo);

            merge(sequencia, primeiro, meio, ultimo);
        }
    }

    static void merge(int[] sequencia, int primeiro, int meio, int ultimo) {

        int[] auxiliar = new int[sequencia.length];

        for (int k = primeiro; k <= ultimo; k++) {
            auxiliar[k] = sequencia[k];
        }

        int i = primeiro; // índice que marca o início do primeiro vetor
        int j = meio + 1; // índice que marca o início do segundo vetor
        int k = primeiro; // índice que marca a posição do menor valor depois da comparação

        // Processo de comparação dos índices de cada vetor
        while (i <= meio && j <= ultimo) {
            if (auxiliar[i] > auxiliar[j]) {
                sequencia[k++] = auxiliar[j++];
                numeroJogadas += (meio - i + 1);
                
            } else {
                sequencia[k++] = auxiliar[i++];
            }
        }

        while (i <= meio) {
            sequencia[k++] = auxiliar[i++];
        }

        while (j <= ultimo) {
            sequencia[k++] = auxiliar[j++];
        }
    }
}