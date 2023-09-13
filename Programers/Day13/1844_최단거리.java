import java.util.*;

class Solution {
    private class Pos {
        int x;
        int y;
        int c; 
        
        Pos(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    
    int[][] d = {{0,1},{0,-1},{-1,0},{1,0}};
    int[][] visited;
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0,0,1));
        while (!q.isEmpty()) {
            Pos now = q.poll();
            
            if (now.x == maps.length-1 && now.y == maps[0].length-1) {
                if (answer == -1 || answer > now.c)
                    answer = now.c;
            } else {
                for (int[] move : d) {
                    int dx = now.x + move[0];
                    int dy = now.y + move[1];

                    if (dx >= 0 && dy >= 0 && dx <maps.length && dy < maps[0].length) {
                        if (maps[dx][dy] == 1 && (visited[dx][dy] == 0 || visited[dx][dy] > now.c ) ) {
                            visited[dx][dy] = now.c;
                            q.add(new Pos(dx,dy,now.c+1));
                        }
                    }
                }
            }   
        }   
        return answer;
    }
}

// dfs로 처리하면 timeout
// bfs로 하되, bool visited 가 아니라  int visited 해서 가성비 따지면서 움직여야 함
