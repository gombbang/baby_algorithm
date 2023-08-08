// dfs bfs  상관은 없는데
// dfs는 일단 바닥찍고 그 다음에 옆으로 퍼질거고 (stack)
// bfs는 처음부터 주변으로 쫙 퍼질 것 (queue)
// 구현은 둘 다 가능

// 완전 탐색
// 도착했으면 visit == true
// 주변 색이 같은 게 있는지 체크
// 있으면 완전탐색은 무시하고 그대로 찾는 로직 ㄱㄱ
// 완전탐색을 거칠 때 마다 +1씩 해서 0번째 인자에 담는다.
// 0라인은 무시

// 현 위치가 i, j 번째 일 때 i j-1 과 i-1 j 는 무시한다, 이미 거쳐온 곳이므로 없다고 확신할 수 있음.

// 예시 코드
// [[1, 1, 1, 0], 
//  [1, 2, 2, 0], 
//  [1, 0, 0, 1], 
//  [0, 0, 0, 1], 
//  [0, 0, 0, 3], 
 // [0, 0, 0, 3]]

// [[1, 1, 1, 0], 
// [1, 1, 1, 0], 
// [0, 0, 0, 1], 
// [0, 0, 0, 1], 
// [0, 0, 0, 1], 
// [0, 0, 0, 1]]
import java.util.*;

class Solution {
    boolean[][] visit;
    int numberOfArea;
    int maxSizeOfOneArea;
    int m;
    int n;
    int areaSize;
    Stack<Node> stack;

    private void loop (int[][] pic) {
        areaSize = 0;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j<n ; j ++) {
                if (pic[i][j] != 0 && !visit[i][j]) {
                    // System.out.println("not 0, i : " + i + ", j : " + j);
                    numberOfArea++;
                    areaSize++;
                    findGround(i,j,pic);
                    maxSizeOfOneArea = maxSizeOfOneArea < areaSize ? areaSize : maxSizeOfOneArea;
                    areaSize = 0;
                } else
                    visit[i][j] = true;
            }
        }
    }
//     사실 반대로 쓰임 ㅎㅎ
    class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        int getX () {
            return x;
        }
        int getY () {
            return y;
        }
    }
    
    private void findGround(int i, int j, int[][] pic) {
        int color = pic[i][j];
        stack.add(new Node(i,j));
        visit[i][j] = true;
        int x = 0;
        int y = 0;
                    // System.out.println("color : "+ color  + " i : " + i + ", j : " + j);
//         m n 을 올린 이유
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            x = node.getX();
            y = node.getY();
            if (0 <= x-1 && pic[x-1][y] == color && !visit[x-1][y]) {
                areaSize++;
                visit[x-1][y] = true;
                stack.push(new Node(x-1,y));
            } 
            if (0 <= y-1 && pic[x][y-1] == color && !visit[x][y-1]) {
                areaSize++;
                visit[x][y-1] = true;
                stack.push(new Node(x,y-1));
            }
            if (m > x+1 && pic[x+1][y] == color && !visit[x+1][y]) {
                areaSize++;
                visit[x+1][y] = true;
                stack.push(new Node(x+1,y));
            } 
            if (n > y+1 && pic[x][y+1] == color && !visit[x][y+1]) {
                areaSize++;
                visit[x][y+1] = true;
                stack.push(new Node(x,y+1));
            }
        }
        
    }

    public int[] solution(int y, int x, int[][] picture) {
        m = y;
        n = x;
        visit = new boolean[m][n];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        stack = new Stack<>();
        

        loop(picture);
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
// 어피치 그림같이 끊겼지만 다른 길로 이어지는 걸 생각하지 못함, 이거는 그냥 땅따먹기 하듯 파고 가는 상황이지만 어피치는 돌아서 이어가잖아.
// https://youjourney.tistory.com/5
