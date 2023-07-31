// k 이상, 두개의 음식을 섞어라
// 가장 안매운거 + (그 다음으로 안매운거*2)
// 
import java.util.*;

class Solution {
    public int solution(int[] s, int K) {
        int answer = 0;
        int a;
        int b;
        int t;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : s) {
            pq.add(i);
        }
        
        while(pq.peek() < K) {
            if (pq.size() == 1)
                return -1;
            
                cnt++;
                a = pq.poll();
                b = pq.poll();
                t = a + (b*2);
                pq.add(t);
        }
        return cnt;
    }
}

// https://chat.openai.com/share/c64c3bb7-266e-43f3-b656-6f816132bfa1
