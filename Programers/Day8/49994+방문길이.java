// 끝점 체크 함수
// 들어온 순서대로 체크, queue
// 자기 위치를 매번 체크
// visited를 xy로 해서 결정 
import java.util.*;

class Solution {
    private boolean[][] visited;
    private boolean isValidate(int x, int y) {
        if (x < 21 && x > -1) 
            if (y < 21 && y > -1)
                return true;
        return false;
    }
    
    public int solution(String dirs) {
        int[] pos = new int[2];
        pos[0] = pos[1] = 10;
        
        visited = new boolean[21][21]; 
        // visited[8][8] = true;
        // 0 : -5, 10 : 0, 20 : 5
        char[] list = dirs.toCharArray();
        Queue<Character> q = new LinkedList<>();
        for (char c : list) {
            q.offer(c);
        }
        
        while (! q.isEmpty()) {
            // System.out.print(q.poll());
            switch (q.poll()) {
                case 'U':
                    if (isValidate(pos[0],pos[1]+2)) {
                        pos[1]+=2;
                        visited[pos[0]][pos[1]-1] = true;
                        // System.out.println("x : " + pos[0] + ", y : " + pos[1]);    
                    }
                    continue;
                case 'D':
                    if (isValidate(pos[0],pos[1]-2)) {
                        pos[1]-=2;
                        visited[pos[0]][pos[1]+1] = true;
                        // System.out.println("x : " + pos[0] + ", y : " + pos[1]);    
                    }
                    continue;
                case 'L':
                    if (isValidate(pos[0]-2,pos[1])) {
                        pos[0]-=2;
                        visited[pos[0]+1][pos[1]] = true;
                        // System.out.println("x : " + pos[0] + ", y : " + pos[1]);    
                    }
                    continue;
                case 'R':
                    if (isValidate(pos[0]+2,pos[1])) {
                        pos[0]+=2;
                        visited[pos[0]-1][pos[1]] = true;
                        // System.out.println("x : " + pos[0] + ", y : " + pos[1]);    
                    }
                    continue;
            }
        }
        
        int answer = 0;
        for (int i = 0; i<21; i++) {
            for (int j = 0; j<21;j++) {
                if (visited[i][j])
                    // System.out.println("x : " + i + ", y : " + j);
                    answer ++;
            }
        }
        
        return answer;
    }
}
