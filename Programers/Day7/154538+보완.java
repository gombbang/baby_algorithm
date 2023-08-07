// 보완 1
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    static class Node{
        int num;
        int count;
        Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    
    int answer = 1000000;
    int[] visited = new int[1000001];
    
    
    public int solution(int x, int y, int n) {
        Deque<Node> deque = new LinkedList<>();
        
        deque.offer(new Node(x,0));
        
        while (deque.size() > 0) {
            Node cur = deque.poll();
            int curNum = cur.num;
            int curCount = cur.count;
            
            if (visited[curNum] != 0 && visited[curNum] < curCount) {
                continue;
            } else 
                visited[curNum] = curCount;
            
            if (curNum == y) {
                return curCount;
            }
            
            if (curNum < y) {
                if (curNum*3 <= y)
                    deque.offer(new Node(curNum*3, curCount+1));
                if (curNum*2 <= y)
                    deque.offer(new Node(curNum*2, curCount+1));   
                if (curNum+n <= y)
                    deque.offer(new Node(curNum+n, curCount+1));
            }
        }
        if (visited[y] == 0)
            return -1;
        
        return visited[y];
    }
} 





// 보완 2, visit 에 대해 boolean으로 수정
// boolean등 초기화되지 않음 -> for 문 돌림 => 전체적인 시간 값 증가
// 초기화가 안되었기에 for (type t : array ) ~ 는 불가능 함.

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    static class Node{
        int num;
        int count;
        Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    
    int answer = 1000000;
    Boolean[] visited = new Boolean[1000001];
    
    
    public int solution(int x, int y, int n) {
        for (int i = 0 ; i<visited.length;i++)
            visited[i] = false;
        
        Deque<Node> deque = new LinkedList<>();
        
        deque.offer(new Node(x,0));
        
        while (deque.size() > 0) {
            Node cur = deque.poll();
            int curNum = cur.num;
            int curCount = cur.count;
            
            if (visited[curNum]) {
                continue;
            } else 
                visited[curNum] = true;
            
            if (curNum == y) {
                return curCount;
            }
            
            if (curNum < y) {
                if (curNum*3 <= y && !visited[curNum*3])
                    deque.offer(new Node(curNum*3, curCount+1));
                if (curNum*2 <= y && !visited[curNum*2])
                    deque.offer(new Node(curNum*2, curCount+1));   
                if (curNum+n <= y && !visited[curNum+n] )
                    deque.offer(new Node(curNum+n, curCount+1));
            }
        }
        return -1;
    }
}


// Long 때도 그렇고 Boolean도 그렇고
// 박스형 type을 안써도 되는데 왜 그럴까
// https://recordsoflife.tistory.com/941, 배열 초기화에 시간 소모가 각 10ms 는 걸리기에 빼보려고 했더니 이렇게 나옴
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    static class Node{
        int num;
        int count;
        Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    
    int answer = 1000000;
    boolean[] visited = new boolean[1000001];
    
    
    public int solution(int x, int y, int n) {
        // for (int i = 0 ; i<visited.length;i++)
        //     visited[i] = false;
        
        Deque<Node> deque = new LinkedList<>();
        
        deque.offer(new Node(x,0));
        
        while (deque.size() > 0) {
            Node cur = deque.poll();
            int curNum = cur.num;
            int curCount = cur.count;
            
            if (visited[curNum]) {
                continue;
            } else 
                visited[curNum] = true;
            
            if (curNum == y) {
                return curCount;
            }
            
            if (curNum < y) {
                if (curNum*3 <= y && !visited[curNum*3])
                    deque.offer(new Node(curNum*3, curCount+1));
                if (curNum*2 <= y && !visited[curNum*2])
                    deque.offer(new Node(curNum*2, curCount+1));   
                if (curNum+n <= y && !visited[curNum+n] )
                    deque.offer(new Node(curNum+n, curCount+1));
            }
        }
        return -1;
    }
} 
