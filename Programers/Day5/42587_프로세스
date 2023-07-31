// array list 말고 그냥 index 돌면서 하나씩 뒤로 넘어가게 하자.
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] answerArray = new int[priorities.length];
        Queue<Integer> queue = new LinkedList<>();
        
        int[] pMinArray = new int[priorities.length];
        int pMinArrayIndex = pMinArray.length-1;
        int order = 0;
        
        for (int i =0; i<priorities.length; i++) {
            pMinArray[i] = priorities[i];
        }
        Arrays.sort(pMinArray);
        
        
        for (int i = 0 ; i<priorities.length; i++) {
            if (pMinArray[pMinArrayIndex] == priorities[i]) {
                answerArray[i] = order+1;
                order += 1;
                pMinArrayIndex -= 1;
            }
            else {
                queue.offer(i);
            }
        }
        int pIndex = -1;
        while ( queue.peek() != null ) {
         // System.out.println("queue, " + queue.poll());
            if (answerArray[location] != 0)
                return answerArray[location];
            else {
                pIndex = queue.poll();
                if (priorities[pIndex] == pMinArray[pMinArrayIndex]) {
                    answerArray[pIndex] = ++order;
                    pMinArrayIndex -= 1;
                } else {
                    queue.offer(pIndex);
                }
            }
        }
        
        return answerArray[location];
    }
}
