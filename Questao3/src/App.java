import java.util.Scanner;

public class App {
    public static void resultado() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0)
                break;

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int inversao = contarInversao(a);

            if ((inversao % 2) == 0) {
                System.out.println("Carlos");
            } else {
                System.out.println("Marcelo");
            }

        }

    }

    public static int contarInversao(int[] a) {
        int total = 0;
        int sortedCount = 0;
        boolean sorted = false;

        while (!sorted) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    total++;
                } else {
                    sortedCount++;
                }
                if (sortedCount == (a.length - 1)) {
                    sorted = true;
                }
            }

            sortedCount = 0;
        }

        return total;

    }

    public static void main(String[] args) throws Exception {
        resultado();
    }
}
