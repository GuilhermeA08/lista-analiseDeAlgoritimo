public class App {
    public static void main(String[] args) throws Exception {
        int n = 4;
        int s[] = { 2, 7, 1, 5 };
        int S = 4;
        boolean existe = verificaSubconjunto(n, s, S);
        if (existe) {
            System.out.println("Existe");
        } else {
            System.out.println("Não Existe");
        }
    }

    public static boolean verificaSubconjunto(int n, int[] s, int S) {
        // cria uma tabela (n+1) x (S+1) com valor inicial false
        boolean[][] table = new boolean[n + 1][S + 1];
        boolean temp;

        // preenche a primeira linha com true, pois é possível obter soma zero
        for (int i = 0; i <= n; i++) {
            table[i][0] = true;
        }

        // preenche a tabela com os valores para i > 0
        for (int c = 1; c <= S; c++) {
            table[0][c] = false;
            for (int l = 1; l <= n; l++) {
                temp = table[l - 1][c];

                if (temp == false && s[l - 1] <= c) {
                    System.out.println();
                    temp = table[l - 1][c - s[l - 1]];
                }
                table[l][c] = temp;
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < S + 1; j++) {
                if (table[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }

        // retorna o valor da célula (n, S)
        return table[n][S];
    }
}
