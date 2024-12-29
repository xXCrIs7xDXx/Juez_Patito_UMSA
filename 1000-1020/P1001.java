import java.util.Scanner;

public class P1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] numeros = new int[N];
        for (int i = 0; i < N; i++) {
            numeros[i] = sc.nextInt();
        }

        for (int num : numeros) {
            System.out.println(num);
        }

        sc.close();
    }
}
