package greedy;

import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String stones = sc.next().trim();
        int total = 0;
        char[] characters = stones.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == 'B')
                continue;

            for (int j = i + 1; j < characters.length; j++) {

                if (characters[j] == 'B' && j == i + 1) {
                    total -= b;
                    char temp = characters[j];
                    characters[j] = characters[i];
                    characters[i] = temp;
                    break;
                }
                if (characters[j] == 'B') {
                    total += a;
                    char temp = characters[j];
                    characters[j] = characters[i];
                    characters[i] = temp;
                    break;
                }

            }
        }

        System.out.println(total);

    }
}
