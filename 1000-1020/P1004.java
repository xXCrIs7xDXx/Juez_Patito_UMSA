import java.util.*;

public class P1004 {
    static class State implements Comparable<State> {
        int x, y, walls;
        
        State(int x, int y, int walls) {
            this.x = x;
            this.y = y;
            this.walls = walls;
        }
        
        @Override
        public int compareTo(State other) {
            return Integer.compare(this.walls, other.walls);
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};  // direcciones para moverse
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int caso = 1; caso <= T; caso++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            char[][] maze = new char[N][M];
            for (int i = 0; i < N; i++) {
                maze[i] = sc.next().toCharArray();
            }
            
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            int result = dijkstra(maze, N, M, x1, y1, x2, y2);
            System.out.println("Laberinto #" + caso + ": " + result);
        }

        sc.close();
    }
    
    static int dijkstra(char[][] maze, int N, int M, int x1, int y1, int x2, int y2) {
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(x1, y1, 0));
        
        while (!pq.isEmpty()) {
            State current = pq.poll();
            
            if (current.x == x2 && current.y == y2) {
                return current.walls;
            }
            
            if (visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;
            
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && !visited[newX][newY]) {
                    int newWalls = current.walls;
                    if (maze[newX][newY] == '#') {
                        newWalls++;
                    }
                    pq.offer(new State(newX, newY, newWalls));
                }
            }
        }
        
        return -1;
    }
}