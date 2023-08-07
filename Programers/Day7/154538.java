import java.util.*;

class Solution {
	//x에 적절한 연산을 취한 횟수와 그 결과를 저장할 Class
    static class Node{
        int num;
        int count;
        Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    static Queue<Node> q;
    static boolean[] visited;
    static int limit = 1000000;
    public int solution(int x, int y, int n) {
        int answer = 0;
        if(x == y)
            return 0;
        q = new LinkedList<>();
        
        //제일 큰 수가 나오는게 3을 곱하는 것이고 각 인덱스를 숫자 그대로 보기위해서 +1
        visited = new boolean[3*limit+1];
        q.offer(new Node(x, 0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int curNum = cur.num;
            int curCount = cur.count;
            if(curNum == y){
                answer = curCount;
                break;
            }
            //각 연산을 취했을 때 나온적이 없는 수인지(!visited)
            //그리고 그 수가 제한조건을 넘어가지 않는지
            if(!visited[curNum+n] && curNum+n <= limit){
                visited[curNum+n] = true;
                q.offer(new Node(curNum+n, curCount+1));
            }
            if(!visited[curNum*2] && curNum*2 <= limit){
                visited[curNum*2] = true;
                q.offer(new Node(curNum*2, curCount+1));
            }
            if(!visited[curNum*3] && curNum*3 <= limit){
                visited[curNum*3] = true;
                q.offer(new Node(curNum*3, curCount+1));
            }
        }
        return answer == 0 ? -1 : answer;
    }
}

// https://berryiscute.tistory.com/19
