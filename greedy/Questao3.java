package greedy;

import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String stones = sc.next().trim();
        char[] characters = stones.toCharArray();
        int start = 0;
        int end = stones.length() - 1;
        int total = 0;

        while (start < end) {
            if (characters[start] == 'B') {
                start++;
                continue;
            }
    
            if (characters[end] == 'W') {
                end--;
                continue;   
            }

            if (end == start + 1) {
                total -= b;
            }

            total += a;
            char temp = characters[end];
            characters[end] = characters[start];
            characters[start] = temp;

        }

        System.out.println(total);
        sc.close();

    }
}
