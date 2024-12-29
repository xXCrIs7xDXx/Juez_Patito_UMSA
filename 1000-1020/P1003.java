import java.util.Scanner;

public class P1003 {
    static int[] parent;
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                union(u, v);
            }

            int X = sc.nextInt();
            int Y = sc.nextInt();

            if (find(X) == find(Y)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
