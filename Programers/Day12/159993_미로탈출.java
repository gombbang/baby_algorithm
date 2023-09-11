import java.util.*;

class Solution {
    String[][] MIRO;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0 , -1, 1};
    
    class Pos {
        int x;
        int y;
        int count;
        Pos(int x,int y, int count) {
            this.x = x;
            this.y= y;
            this.count = count;
        }
    }
    
    public int solution(String[] maps) {
        MIRO = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] labor = new int[2];
        
        for(int i = 0; i<maps.length; i++) {
            String[] tmp = maps[i].split("");
            
            for(int j = 0; j<tmp.length; j++) {
                MIRO[i][j] = tmp[j];
                
                if (MIRO[i][j].equals("S")) {
                    start = new int[]{i, j};
                }
    
                if (MIRO[i][j].equals("L")) {
                    labor = new int[]{i, j};
                }
            }
        }
        
        
        
        int result = bfs(start, "L");
        if (result == -1)
            return -1;
        
        int result2 = bfs(labor, "E");
        
        if (result2 == -1)
            return -1;
        
        return result + result2;
    }
    
    public int bfs(int[] start, String target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});

        boolean[][] visited = new boolean[MIRO.length][MIRO[0].length];

        while(!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int count = queue.peek()[2];
            visited[x][y] = true;

            if (MIRO[x][y].equals(target)) {
                return count;
            }

            queue.poll();

            for(int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < MIRO.length && ny >= 0 && ny < MIRO[0].length && !visited[nx][ny]) {
                    if (!MIRO[nx][ny].equals("X")) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, count+1});
                    }
                }
            }
        }

        return -1;
    }
}

// https://chamggae.tistory.com/199
// 자괴감
