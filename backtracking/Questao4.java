package backtracking;

import java.util.Scanner;

public class Questao4 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int numeroTestes = sc.nextInt();
        int[][] matrizLabirinto;
        boolean[][] blocosPercorridos;

        for (int i = 0; i < numeroTestes; i++) {
            
            matrizLabirinto = new int[5][5];
            blocosPercorridos = new boolean[5][5];

            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    matrizLabirinto[j][k] = sc.nextInt();
                }
            }

            if(backtracking(matrizLabirinto, blocosPercorridos, 0, 0)) {
                System.out.println("COPS");
            } else {
                System.out.println("ROBBERS");
            }

        }

        sc.close();

    }

    public static boolean backtracking(int[][] labirinto, boolean[][] percorridos, int x, int y) {

        percorridos[x][y] = true;

        if (x == 4 && y == 4) {
            return true;
        }

        // Verifica se é possível se mover para a esquerda
        if (y > 0 && labirinto[x][y-1] == 0 && !percorridos[x][y-1]) {
            if (backtracking(labirinto, percorridos, x, y-1)) {
                return true;
            }
        }
        
        // Verifica se é possível se mover para a direita
        if (y < 4 && labirinto[x][y+1] == 0 && !percorridos[x][y+1]) {
            if (backtracking(labirinto, percorridos, x, y+1)) {
                return true;
            }
        }
        
        // Verifica se é possível se mover para cima
        if (x > 0 && labirinto[x-1][y] == 0 && !percorridos[x-1][y]) {
            if (backtracking(labirinto, percorridos, x-1, y)) {
                return true;
            }
        }
        
        // Verifica se é possível se mover para baixo
        if (x < 4 && labirinto[x+1][y] == 0 && !percorridos[x+1][y]) {
            if (backtracking(labirinto, percorridos, x+1, y)) {
                return true;
            }
        }

        return false;

    }

}
